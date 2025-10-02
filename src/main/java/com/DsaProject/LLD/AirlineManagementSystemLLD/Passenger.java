package com.DsaProject.LLD.AirlineManagementSystemLLD;

import java.util.UUID;

public class Passenger {
    String id;
    String name;
    String email;
    public Passenger(String name, String email)
    {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
    }

    public String getId()
    {
        return this.id;
    }
}
