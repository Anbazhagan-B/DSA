package com.DsaProject.LLD.MovieBookingLLD.strategy.pricing;

import com.DsaProject.LLD.MovieBookingLLD.entities.Seat;

import java.util.List;

public interface PricingStrategy {
    double calculatePrice(List<Seat> seats);
}
