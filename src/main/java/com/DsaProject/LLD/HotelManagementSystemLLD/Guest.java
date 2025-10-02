package com.DsaProject.LLD.HotelManagementSystemLLD;

public class Guest {
    String id;
    String name;
    String email;
    String phoneNumber;

    public Guest(String id, String name, String email, String phoneNumber)
    {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
