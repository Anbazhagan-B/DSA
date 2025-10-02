package com.DsaProject.LLD.HotelManagementSystemLLD;

import com.DsaProject.LLD.HotelManagementSystemLLD.payment.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HotelManagementSystem {
    static HotelManagementSystem instance;
    Map<String, Guest> guests;
    Map<String, Room> rooms;
    Map<String, Reservation> reservations;

    HotelManagementSystem()
    {
        guests = new HashMap<>();
        rooms = new HashMap<>();
        reservations = new HashMap<>();
    }
    public synchronized Reservation bookRoom(Guest guest, Room room, LocalDate startDate, LocalDate endDate)
    {
        if(room.getStatus() == RoomStatus.AVAILABLE)
        {
            room.book();
            String reservationId = getReservationId();
            Reservation reservation = new Reservation(reservationId, guest, room, startDate, endDate);
            reservations.put(reservationId, reservation);
            return reservation;
        }

        throw new RuntimeException("Room is booking is failed");
    }

    public synchronized void cancelReservation(String reservationId)
    {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null)
        {
            reservation.cancel();
            reservations.remove(reservationId);
        }
    }

    public void checkIn(String reservationId)
    {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED)
        {
            reservation.getRoom().checkIn();
        }
        else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
        }
    }

    public void checkOut(String reservationId, Payment payment)
    {
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null && reservation.getReservationStatus() == ReservationStatus.CONFIRMED)
        {
            Room room = reservation.getRoom();
            double price = room.getPrice() * ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());
            if(payment.processPayment(price) && room.getStatus() == RoomStatus.OCCUPIED)
            {
                reservation.getRoom().checkout();
                reservations.remove(reservationId);
            }
        }
        else {
            throw new IllegalStateException("Invalid reservation or reservation not confirmed.");
        }
    }

    public static HotelManagementSystem getInstance() {
        if(instance == null)
        {
            instance = new HotelManagementSystem();
        }

        return instance;
    }

    String getReservationId()
    {
        return  "RES-"+ UUID.randomUUID().toString().substring(0, 8);
    }

    public void addRoom(Room room)
    {
        rooms.put(room.getId(), room);
    }

    public void addGuest(Guest guest)
    {
        guests.put(guest.getId(), guest);
    }
}
