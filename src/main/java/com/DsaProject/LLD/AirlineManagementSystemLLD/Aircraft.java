package com.DsaProject.LLD.AirlineManagementSystemLLD;

public class Aircraft {
    final String tailNumber;
    final String model;
    final int totalSeats;

    public Aircraft(String tailNumber, String model, int totalSeats)
    {
        this.model = model;
        this.tailNumber = tailNumber;
        this.totalSeats = totalSeats;
    }

    public String getTailNumber(){
        return this.tailNumber;
    }

}
