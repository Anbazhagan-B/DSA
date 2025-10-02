package com.DsaProject.LLD.VendingMachine;

public class UserSession {
    String name;
    int amount;

    public UserSession(String name)
    {
        this.name = name;
    }

    public int getAmount()
    {
        return this.amount;
    }

    public void addAmount(int amount)
    {
        this.amount = this.amount + amount;
    }

}
