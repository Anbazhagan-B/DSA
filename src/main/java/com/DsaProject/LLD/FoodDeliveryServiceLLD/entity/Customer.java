package com.DsaProject.LLD.FoodDeliveryServiceLLD.entity;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.order.Order;
import com.DsaProject.Thread.StringRunnable;

import java.util.*;

public class Customer extends User{
    Address address;
    List<Order> orderHistory = new ArrayList<>();

    public Customer(String name, String phone, Address address)
    {
        super(name, phone);
        this.address = address;
    }

    public void addOrderToHistory(Order order)
    {
        this.orderHistory.add(order);
    }

    public Address getAddress(){return address; }

    @Override public void onUpdate(Order order) {
        System.out.printf("--- Notification for Customer %s ---\n", getName());
        System.out.printf("  Order %s is now %s.\n", order.getId(), order.getStatus());
        System.out.println("-------------------------------------\n");
    }
}
