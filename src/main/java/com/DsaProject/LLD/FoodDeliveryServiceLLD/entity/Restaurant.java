package com.DsaProject.LLD.FoodDeliveryServiceLLD.entity;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.observer.OrderObserver;
import com.DsaProject.LLD.FoodDeliveryServiceLLD.order.Order;

import java.util.UUID;

public class Restaurant implements OrderObserver {
    String id;
    String name;
    Address address;
    Menu menu;

    public Restaurant(String name, Address address)
    {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address =address;
        this.menu = new Menu();
    }
    public void addToMenu(MenuItem item) { this.menu.addItem(item); }

    public String getId() { return id; }
    public String getName() { return name; }
    public Address getAddress() { return address; }
    public Menu getMenu() { return menu; }

    @Override
    public void onUpdate(Order order) {
        System.out.printf("--- Notification for Restaurant %s ---\n", getName());
        System.out.printf("  Order %s has been updated to %s.\n", order.getId(), order.getStatus());
        System.out.println("---------------------------------------\n");
    }
}
