package com.DsaProject.LLD.CarRentalSystemLLD;

public class Customer {
    String name;
    String contactInfo;
    String drivingLicenseNumber;

    public Customer(String name, String contactInfo, String drivingLicenseNumber)
    {
        this.name = name;
        this.contactInfo = contactInfo;
        this.drivingLicenseNumber = drivingLicenseNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getDrivingLicenseNumber() {
        return drivingLicenseNumber;
    }

    public String getName() {
        return name;
    }
}
