package com.DsaProject.LLD.MovieBookingLLD.entities;

import com.DsaProject.LLD.MovieBookingLLD.observer.MovieSubject;

public class Movie extends MovieSubject {
    private final String id;
    private final String title;
    private final int durationInMinutes;

    public Movie(String id, String title, int durationInMinutes)
    {
        this.id = id;
        this.title = title;
        this.durationInMinutes = durationInMinutes;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
