package LLD2.FoofDeliverySystem.entity;

import LLD2.FoofDeliverySystem.observer.OrderObserver;

import javax.swing.*;
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
        this.address = address;
        this.menu = new Menu();
    }

    @Override
    public void onUpdate(Order order) {

    }
}
