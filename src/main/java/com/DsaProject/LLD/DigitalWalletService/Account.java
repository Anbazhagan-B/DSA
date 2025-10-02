package com.DsaProject.LLD.DigitalWalletService;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
    String id;
    User user;
    String accountNumber;
    Currency currency;
    BigDecimal balance;
    List<Transaction> transactions;

    public Account(String id, User user, String accountNumber, Currency currency)
    {
        this.id = id;
        this.user = user;
        this.accountNumber =accountNumber;
        this.currency = currency;
        this.balance = BigDecimal.ONE;
        this.transactions = new ArrayList<>();
    }

    public synchronized  void deposit(BigDecimal amount)
    {
        this.balance = this.balance.add(amount);
    }

    public synchronized void withdraw(BigDecimal amount)
    {
        if(balance.compareTo(amount) >= 0)
        {
            this.balance = this.balance.subtract(amount);
        }
        else
        {
            throw  new RuntimeException("Insufficient Funds in the account");
        }
    }

    public synchronized void addTransaction(Transaction transaction)
    {
        this.transactions.add(transaction);
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
