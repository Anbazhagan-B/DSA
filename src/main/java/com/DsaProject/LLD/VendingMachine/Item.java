package com.DsaProject.LLD.VendingMachine;

public class Item {
    int id;
    String name;
    int price;

    public Item(String name, int price)
    {
        this.id = (int)System.currentTimeMillis() % Integer.MAX_VALUE;
        this.name = name;
        this.price = price;
    }
}
