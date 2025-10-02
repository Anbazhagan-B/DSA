package com.DsaProject.LLD.AtmLLD;

public class CashDispenser {
    double cashAvailable;

    public CashDispenser(double initialCash)
    {
        this.cashAvailable = initialCash;
    }

    synchronized void dispenseCash(double amount)
    {
        if(amount > cashAvailable)
            throw new RuntimeException("Atm is not enought cash. Right now!");
        this.cashAvailable -= amount;
    }
}
