package LLD2.FoofDeliverySystem.entity;

import LLD2.FoofDeliverySystem.observer.OrderObserver;

import java.util.UUID;

public abstract class User implements OrderObserver {
    String id;
    String name;
    String phoneNumber;

    public User(String name, String phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
