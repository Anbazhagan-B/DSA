package com.DsaProject.LLD.AirlineManagementSystemLLD.Seat;

public class Seat {
    String seatNumber;
    SeatType seatType;
    SeatStatus seatStatus;

    public Seat(String seatNumber, SeatType seatType)
    {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    public String getSeatNumber()
    {
        return seatNumber;
    }

    public void reserve()
    {
        this.seatStatus = SeatStatus.RESERVED;
    }

    public void release()
    {
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public synchronized boolean isBooked()
    {
        return this.seatStatus == SeatStatus.OCCUPIED;
    }
}
