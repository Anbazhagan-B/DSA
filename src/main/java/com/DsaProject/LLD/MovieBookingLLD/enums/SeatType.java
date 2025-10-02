package com.DsaProject.LLD.MovieBookingLLD.enums;

import com.DsaProject.LLD.AirlineManagementSystemLLD.Seat.Seat;

public enum SeatType {
    REGULAR(20.0),
    PREMIUM(80.0),
    RECLINER(100.0);

    double price;

    private SeatType(double price)
    {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
