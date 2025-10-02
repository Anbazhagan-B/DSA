package com.DsaProject.LLD.TaskManagementLLD;

import java.util.UUID;

public class User {
    String id;
    String name;
    String email;

    public User(String name, String email)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
    }

    public String getName()
    {
        return this.name;
    }
}
