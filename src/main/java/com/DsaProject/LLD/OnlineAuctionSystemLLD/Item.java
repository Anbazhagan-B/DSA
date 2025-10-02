package com.DsaProject.LLD.OnlineAuctionSystemLLD;

public class Item {
    String name;
    String description;

    public Item(String name, String description)
    {
        this.description = description;
        this.name = name;
    }
    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return this.description;
    }
}
