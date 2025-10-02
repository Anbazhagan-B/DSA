package com.DsaProject.LLD.FoodDeliveryServiceLLD.entity;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.order.Order;

import java.util.concurrent.atomic.AtomicBoolean;

public class DeliveryAgent extends User {
    AtomicBoolean isAvailable = new AtomicBoolean(true);
    Address currentLocation;

    public DeliveryAgent(String name, String phone, Address currentLocation)
    {
        super(name, phone);
        this.currentLocation = currentLocation;
    }

    public void setIsAvailable(boolean available)
    {
        this.isAvailable.set(available);
    }

    public synchronized boolean isAvailable(){return isAvailable.get(); }

    public void setCurrentLocation(Address currentLocation)
    {
        this.currentLocation = currentLocation;
    }

    public Address getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void onUpdate(Order order)
    {
        System.out.printf("--- Notification for Delivery Agent %s ---\n", getName());
        System.out.printf("  Order %s update: Status is %s.\n", order.getId(), order.getStatus());
        System.out.println("-------------------------------------------\n");
    }
}
