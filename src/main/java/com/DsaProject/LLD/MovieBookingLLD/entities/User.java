package com.DsaProject.LLD.MovieBookingLLD.entities;

import java.util.UUID;

public class User {
    String id;
    String name;
    String email;

    public User(String name, String email)
    {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
