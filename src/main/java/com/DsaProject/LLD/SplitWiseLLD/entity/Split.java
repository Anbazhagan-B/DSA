package com.DsaProject.LLD.SplitWiseLLD.entity;

public class Split {
    User user;
    double amount;

    public Split(User user, double amount)
    {
        this.user = user;
        this.amount = amount;
    }

    public User getUser()
    {
        return  user;
    }

    public double getAmount() {
        return amount;
    }
}
