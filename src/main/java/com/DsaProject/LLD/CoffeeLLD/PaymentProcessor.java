package com.DsaProject.LLD.CoffeeLLD;

public class PaymentProcessor {
    public void processPayment(Payment payment)
    {
        System.out.println("Payment " + payment.getAmount() + " is Processing");
    }
}
