package com.DsaProject.LLD.CarRentalSystemLLD.payment;

public class PayPalPaymentProcessor implements PaymentProcessor {
    @Override
    public boolean processPayment(double amount) {
        // Process PayPal payment
        // ...
        return true;
    }
}
