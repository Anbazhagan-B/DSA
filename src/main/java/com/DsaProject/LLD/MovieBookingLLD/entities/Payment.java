package com.DsaProject.LLD.MovieBookingLLD.entities;

import com.DsaProject.LLD.MovieBookingLLD.enums.PaymentStatus;

import java.util.UUID;

public class Payment {
    String id;
    double amount;
    PaymentStatus status;
    String transactionId;

    public Payment(double amount, PaymentStatus status, String transactionId)
    {
        this.id = UUID.randomUUID().toString();
        this.amount = amount;
        this.status = status;
        this.transactionId = transactionId;
    }

    public PaymentStatus getStatus()
    {
        return status;
    }
}
