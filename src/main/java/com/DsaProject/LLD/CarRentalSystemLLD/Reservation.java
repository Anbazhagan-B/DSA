package com.DsaProject.LLD.CarRentalSystemLLD;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {
    String reservationId;
    Customer customer;
    Car car;
    LocalDate startDate;
    LocalDate endDate;
    double totalPrice;

    public Reservation(String reservationId, Customer customer, Car car, LocalDate startDate, LocalDate endDate)
    {
        this.reservationId = reservationId;
        this.customer = customer;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalPrice = calculateTotalPrice();
    }

    double calculateTotalPrice()
    {
        long rentalDays = ChronoUnit.DAYS.between(startDate , endDate) + 1;
        return rentalDays * car.getRentalPerDay();
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getStartDate()
    {
        return startDate;
    }

    public String getReservationId()
    {
        return reservationId;
    }
}
