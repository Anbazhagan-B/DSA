package com.DsaProject.LLD.MovieBookingLLD.strategy.pricing;

import com.DsaProject.LLD.MovieBookingLLD.entities.Seat;

import java.util.List;

public class WeekdayPricingStrategy implements  PricingStrategy{
    @Override
    public double calculatePrice(List<Seat> seats) {
        return seats.stream().mapToDouble(seat -> seat.getSeatType().getPrice()).sum();
    }
}
