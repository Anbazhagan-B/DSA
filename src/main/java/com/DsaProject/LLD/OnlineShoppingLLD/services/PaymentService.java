package com.DsaProject.LLD.OnlineShoppingLLD.services;


import com.DsaProject.LLD.OnlineShoppingLLD.strategy.PaymentStrategy;

public class PaymentService {
    public boolean processPayment(PaymentStrategy strategy, double amount) {
        return strategy.pay(amount);
    }
}
