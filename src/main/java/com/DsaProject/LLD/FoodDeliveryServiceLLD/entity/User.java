package com.DsaProject.LLD.FoodDeliveryServiceLLD.entity;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.observer.OrderObserver;

import java.util.UUID;

public abstract class User implements OrderObserver {
    String id;
    String name;
    String phone;

    public User(String name, String phone)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
