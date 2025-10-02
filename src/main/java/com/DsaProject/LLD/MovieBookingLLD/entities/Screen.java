package com.DsaProject.LLD.MovieBookingLLD.entities;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    String id;
    List<Seat> seats;

    public Screen(String id)
    {
        this.id = id;
        this.seats = new ArrayList<>();
    }

    public String getId()
    {
        return id;
    }

    public void addSeat(Seat seat){
        this.seats.add(seat);
    }

    public List<Seat> getSeats() {
        return seats;
    }

}
