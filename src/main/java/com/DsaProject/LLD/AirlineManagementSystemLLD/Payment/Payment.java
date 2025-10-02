package com.DsaProject.LLD.AirlineManagementSystemLLD.Payment;

public class Payment {
    String paymentId;
    String paymentMethod;
    double amount;
    PaymentStatus status;

    public Payment(String paymentId, String paymentMethod, double amount, PaymentStatus status)
    {
        this.paymentId = paymentId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.status = status;
    }

    public void processPayment()
    {
        this.status = PaymentStatus.COMPLETED;
    }
}
