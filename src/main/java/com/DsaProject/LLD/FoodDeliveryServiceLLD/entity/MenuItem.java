package com.DsaProject.LLD.FoodDeliveryServiceLLD.entity;

public class MenuItem {
    String id;
    String name;
    double price;
    boolean available;

    public MenuItem(String id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public  String getMenuItem()
    {
        return "Name: "+ name + ", Price: "+ price;
    }
}
