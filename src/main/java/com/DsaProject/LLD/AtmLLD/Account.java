package com.DsaProject.LLD.AtmLLD;

public class Account {
    String accountNumber;
    double balance;

    public Account(String accountNumber, double balance)
    {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public void credit(double amount)
    {
        this.balance += amount;
    }

    public void debit(double amount)
    {
        this.balance -= amount;
    }

    public String getAccountNumber()
    {
        return this.accountNumber;
    }

    public double getBalance()
    {
        return this.balance;
    }
}
