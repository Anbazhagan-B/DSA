package com.DsaProject.LLD.AirlineManagementSystemLLD.Booking;

import com.DsaProject.LLD.AirlineManagementSystemLLD.Flight.Flight;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Passenger;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Seat.Seat;

public class Booking {
    String id;
    Flight flight;
    Passenger passenger;
    Seat seat;
    double price;
    BookingStatus status;

    public Booking(String bookingId, Flight flight, Passenger passenger, Seat seat, double price)
    {
        this.id = bookingId;
        this.flight = flight;
        this.passenger = passenger;
        this.seat = seat;
        this.price = price;
        this.status = BookingStatus.CONFIRMED;
    }
    public void cancel()
    {
        this.status = BookingStatus.CANCELLED;
    }

    public String getId()
    {
        return this.id;
    }
}
