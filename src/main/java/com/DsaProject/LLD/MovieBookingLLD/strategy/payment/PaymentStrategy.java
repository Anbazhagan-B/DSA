package com.DsaProject.LLD.MovieBookingLLD.strategy.payment;

import com.DsaProject.LLD.MovieBookingLLD.entities.Payment;

public interface PaymentStrategy {
    Payment pay(double amount);
}
