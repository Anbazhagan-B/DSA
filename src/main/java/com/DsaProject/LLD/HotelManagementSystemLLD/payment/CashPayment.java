package com.DsaProject.LLD.HotelManagementSystemLLD.payment;

public class CashPayment implements Payment{

    @Override
    public boolean processPayment(double paymentAmount) {
        System.out.println("Cash Payment is processed of " +paymentAmount);
        return true;
    }
}
