package com.DsaProject.LLD.ConcertBookingLLD;

import com.DsaProject.LLD.AirlineManagementSystemLLD.Booking.BookingStatus;

import java.util.List;

public class Booking {
    String id;
    User user;
    Concert concert;
    List<Seat> seats;
    double price;
    BookingStatus status;

    public Booking(String id, User user, Concert concert, List<Seat> seats)
    {
        this.id = id;
        this.seats = seats;
        this.user = user;
        this.concert = concert;
        this.price = 0;
        this.status = BookingStatus.PENDING;
    }

    double getTotalPrice()
    {
        return seats.stream().mapToDouble(Seat::getPrice).sum();
    }

    public void confirmBooking()
    {
        if(this.status == BookingStatus.PENDING)
        {
            this.status = BookingStatus.CONFIRMED;
        }
    }

    public void cancelBooking()
    {
        if(this.status == BookingStatus.CONFIRMED)
        {
            this.status = BookingStatus.CANCELLED;
            seats.forEach(Seat::release);
            System.out.printf("Booking is cancelled %s", this.id);
        }
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public Concert getConcert() {
        return concert;
    }

    public User getUser() {
        return user;
    }


}
