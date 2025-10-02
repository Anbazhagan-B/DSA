package com.DsaProject.LLD.DigitalWalletService;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    String id;
    Account sourceAccount;
    Account destinationAccount;
    BigDecimal amount;
    Currency currency;
    LocalDateTime timestamp;
    public Transaction(String id, Account sourceAccount, Account destinationAccount, BigDecimal amount, Currency currency)
    {
        this.id = id;
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.currency = currency;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Account getDestinationAccount() {
        return destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Account getSourceAccount() {
        return sourceAccount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }
}
