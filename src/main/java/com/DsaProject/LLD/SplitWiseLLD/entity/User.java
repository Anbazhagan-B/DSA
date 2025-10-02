package com.DsaProject.LLD.SplitWiseLLD.entity;

import java.util.UUID;

public class User {
    String id;
    String name;
    String email;
    BalanceSheet balanceSheet;

    public User(String name, String email)
    {
        this.id = UUID.randomUUID().toString();
        this.email = email;
        this.name = name;
        this.balanceSheet = new BalanceSheet(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }
}
