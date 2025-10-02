package com.DsaProject.LLD.MovieBookingLLD.entities;

import com.DsaProject.LLD.MovieBookingLLD.strategy.pricing.PricingStrategy;

import java.time.LocalDateTime;

public class Show {
    String id;
    Movie movie;
    Screen screen;
    LocalDateTime startTime;
    PricingStrategy pricingStrategy;

    public Show(String id, Movie movie, Screen screen, LocalDateTime startTime, PricingStrategy pricingStrategy)
    {
        this.id = id;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.pricingStrategy = pricingStrategy;
    }

    public String getId()
    {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }
}
