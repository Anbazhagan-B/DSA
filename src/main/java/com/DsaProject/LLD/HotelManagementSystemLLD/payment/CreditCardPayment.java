package com.DsaProject.LLD.HotelManagementSystemLLD.payment;

public class CreditCardPayment implements Payment{

    @Override
    public boolean processPayment(double paymentAmount) {
        System.out.println("Credit Card  Payment is processed of" +paymentAmount);
        return true;
    }
}
