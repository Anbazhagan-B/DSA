package com.DsaProject.LLD.CarRentalSystemLLD;


import com.DsaProject.LLD.CarRentalSystemLLD.payment.CreditCardPaymentProcessor;
import com.DsaProject.LLD.CarRentalSystemLLD.payment.PaymentProcessor;

import java.time.LocalDate;
import java.util.*;

public class CarRentalSystem {
    static CarRentalSystem instance;
    Map<String, Car> cars;
    Map<String, Reservation> reservations;
    PaymentProcessor paymentProcessor;

    public CarRentalSystem()
    {
        this.cars = new HashMap<>();
        this.reservations = new HashMap<>();
        paymentProcessor = new CreditCardPaymentProcessor();
    }

    public void addCar(Car car)
    {
        cars.put(car.getLicensePlate(), car);
    }

    public void removeCar(Car car)
    {
        cars.remove(car.getLicensePlate());
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate)
    {
        List<Car> availableCars = new ArrayList<>();
        for(Car car : cars.values())
        {
            if(car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model) && car.getCarStatus() == CarStatus.AVAILABLE)
            {
                if(isCarAvailable(car, startDate, endDate))
                {
                    availableCars.add(car);
                }
            }
        }

        return availableCars;
    }

    public boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate)
    {
        for (Reservation reservation: reservations.values())
        {
            if(reservation.getCar().equals(car))
            {
                return startDate.isBefore(reservation.getEndDate()) && endDate.isAfter(reservation.getStartDate());
            }
        }
        return true;
    }

    public synchronized Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate)
    {
        if(isCarAvailable(car, startDate, endDate))
        {
             String reservationId = getReservationId();
             Reservation reservation = new Reservation(reservationId, customer, car, startDate, endDate);
             car.setCarStatus(CarStatus.BOOKED);
             reservations.put(reservationId, reservation);
             return reservation;
        }
        return null;
    }

    public synchronized void cancelReservation(String reservationId)
    {
        Reservation cancelReservation = reservations.remove(reservationId);
        if(cancelReservation  != null)
        {
           Car car = cancelReservation.getCar();
           car.setCarStatus(CarStatus.AVAILABLE);
        }
    }

    public boolean processPayment(Reservation reservation)
    {
        return  paymentProcessor.processPayment(reservation.getTotalPrice());
    }

    private  String getReservationId()
    {
        return "RES:" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static synchronized CarRentalSystem getInstance() {
        if (instance == null) {
            instance = new CarRentalSystem();
        }
        return instance;
    }
}
