package com.DsaProject.LLD.HotelManagementSystemLLD;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Reservation {
    String id;
    Guest guest;
    Room room;
    LocalDate checkInDate;
    LocalDate checkOutDate;
    ReservationStatus reservationStatus;

    public Reservation(String reservationId ,Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate)
    {
        this.id = reservationId;
        this.guest = guest;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.reservationStatus = ReservationStatus.CONFIRMED;
    }

    public String getId() {
        return id;
    }
    public synchronized void cancel()
    {
        if(this.reservationStatus == ReservationStatus.CONFIRMED)
        {
            this.reservationStatus = ReservationStatus.CANCELLED;
            this.room.checkout();
        }
        else
        {
            throw new RuntimeException("Reservation cannot be cancelled");
        }
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

}

