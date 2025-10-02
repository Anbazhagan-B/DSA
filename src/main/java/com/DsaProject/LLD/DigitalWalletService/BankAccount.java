package com.DsaProject.LLD.DigitalWalletService;

import java.math.BigDecimal;

public class BankAccount extends PaymentMethod{

    String accountNumber;
    String routingNumber;
    public BankAccount(String id, User user, String accountNumber,  String routingNumber)
    {
        super(id, user);
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean processPayment(BigDecimal amount, Currency currency) {
        return true;
    }
}
