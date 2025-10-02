package com.DsaProject.LLD.ConcertBookingLLD;

public class User {
    String id;
    String name;
    String email;

    public User(String id, String name, String email)
    {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
