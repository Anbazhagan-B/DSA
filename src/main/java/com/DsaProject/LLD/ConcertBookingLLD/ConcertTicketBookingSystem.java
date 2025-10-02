package com.DsaProject.LLD.ConcertBookingLLD;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ConcertTicketBookingSystem {
    static ConcertTicketBookingSystem instance;
    Map<String , Concert> concerts;
    Map<String, Booking> bookings;
    Object lock = new Object();
    public ConcertTicketBookingSystem()
    {
        this.bookings = new HashMap<>();
        this.concerts = new HashMap<>();
    }

    public static synchronized ConcertTicketBookingSystem getInstance()
    {
        if(instance == null)
        {
            instance = new ConcertTicketBookingSystem();
        }

        return instance;
    }

    public void addConcert(Concert concert)
    {
        concerts.put(concert.getId(), concert);
    }

    public Concert getConcert(String concertId)
    {
        return concerts.get(concertId);
    }

    public List<Concert> searchConcert(String artist, String venue, LocalDateTime dateTime)
    {
        return concerts.values().stream().filter(concert -> concert.getArtist().equalsIgnoreCase(artist)
        && concert.getVenue().equalsIgnoreCase(venue) && concert.getDateTime().equals(dateTime)).toList();
    }

    public Booking bookTickets(User uer, Concert concert, List<Seat> seats)
    {
        synchronized (lock)
        {
            for(Seat seat: seats)
            {
                if(!seat.isAvailable())
                    throw new RuntimeException("Seats not available");
            }

            seats.forEach(Seat::book);

            String bookingId = getBookingId();
            Booking booking = new Booking(bookingId, uer, concert, seats);
            bookings.put(bookingId, booking);
            processingPayment(booking);
            booking.confirmBooking();
            return booking;
        }
    }

    public void cancelBooking(String bookingId)
    {
        Booking booking = bookings.get(bookingId);
        if(booking != null)
        {
            booking.cancelBooking();
            bookings.remove(bookingId);
        }
    }
    void processingPayment(Booking booking)
    {
        System.out.println("Payment is processing :-" + booking.getId());
    }

    String getBookingId()
    {
        return "BKG"+ UUID.randomUUID().toString();
    }
}
