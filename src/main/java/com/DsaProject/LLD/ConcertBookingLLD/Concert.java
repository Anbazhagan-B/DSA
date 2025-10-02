package com.DsaProject.LLD.ConcertBookingLLD;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Concert {
    String id;
    String artist;
    String venue;
    LocalDateTime dateTime;
    List<Seat> seats;

    public Concert(String id, String artist, String venue, LocalDateTime dateTime, List<Seat> seats)
    {
        this.id = id;
        this.artist = artist;
        this.venue = venue;
        this.dateTime = dateTime;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getArtist() {
        return artist;
    }

    public String getVenue() {
        return venue;
    }
}
