package com.DsaProject.LLD.AtmLLD;

public abstract class Transaction {
    String transactionId;
    Account account;
    double amount;

    public Transaction(String transactionId, Account account, double amount)
    {
        this.account = account;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    abstract void execute();

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
