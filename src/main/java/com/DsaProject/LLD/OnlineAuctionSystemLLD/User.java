package com.DsaProject.LLD.OnlineAuctionSystemLLD;

public class User {
    int id;
    String userName;
    String email;
    public User(String userName, String email)
    {
        this.userName = userName;
        this.email = email;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public int getId()
    {
        return this.id;
    }
}
