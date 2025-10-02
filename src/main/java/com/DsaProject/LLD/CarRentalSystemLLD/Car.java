package com.DsaProject.LLD.CarRentalSystemLLD;

public class Car {
    final String make;
    final String model;
    final  int year;
    final  String licensePlate;
    final  double rentalPerDay;
    CarStatus carStatus;

    public Car(String make, String model, int year, String licensePlate, double rentalPerDay)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
        this.rentalPerDay = rentalPerDay;
        this.carStatus = CarStatus.AVAILABLE;
    }

    public String getMake()
    {
        return this.make;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public double getRentalPerDay() {
        return rentalPerDay;
    }

    public int getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    public String getModel() {
        return model;
    }
}
