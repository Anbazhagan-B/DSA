package com.DsaProject.LLD.AirlineManagementSystemLLD.Booking;

import com.DsaProject.LLD.AirlineManagementSystemLLD.Flight.Flight;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Passenger;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Seat.Seat;

import java.util.*;

public class BookingManager {
    static BookingManager instance;
    Map<String, Booking> bookings;
    final Object lock = new Object();

    public BookingManager()
    {
        this.bookings = new HashMap<>();
    }

    public BookingManager getInstance()
    {
        if(instance == null)
        {
            instance = new BookingManager();
        }

        return instance;
    }

    public Booking createBooking(Passenger passenger, Flight flight, Seat seat, double price)
    {
        String bookingId = UUID.randomUUID().toString();
        Booking booking = new Booking(bookingId, flight, passenger, seat, price);
        synchronized (lock)
        {
            bookings.put(bookingId, booking);
        }

        return booking;
    }

    public void cancelBooking(String bookingId)
    {
        synchronized (lock)
        {
            Booking booking = bookings.get(bookingId);
            if(booking != null)
            {
                booking.cancel();
            }
        }
    }
}
