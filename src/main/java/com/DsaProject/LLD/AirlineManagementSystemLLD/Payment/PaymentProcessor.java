package com.DsaProject.LLD.AirlineManagementSystemLLD.Payment;

public class PaymentProcessor {
    static PaymentProcessor instance;

    public PaymentProcessor(){}

    public PaymentProcessor getInstance()
    {
        if(instance == null)
        {
            return new PaymentProcessor();
        }

        return instance;
    }

    public boolean processPayment(Payment payment)
    {
         payment.processPayment();
         return true;
    }
}
