package com.DsaProject.LLD.DigitalWalletService;

import java.math.BigDecimal;

public class CreditCard extends PaymentMethod{
    String cardNumber;
    String cvv;
    String expirationDate;
    public CreditCard(String id, User user, String cardNumber, String cvv, String expirationDate)
    {
        super(id, user);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean processPayment(BigDecimal amount, Currency currency) {
        return true;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
}
