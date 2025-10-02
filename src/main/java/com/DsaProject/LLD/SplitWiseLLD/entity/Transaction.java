package com.DsaProject.LLD.SplitWiseLLD.entity;

public class Transaction {
    User from;
    User to;
    double amount;

    public Transaction(User from, User to, double amount)
    {
        this.amount =amount;
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return from.getName() + " should pay " + to.getName() + " $" + String.format("%.2f", amount);
    }


}
