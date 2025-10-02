package com.DsaProject.LLD.ConcertBookingLLD;


public class Seat {
    String id;
    String seatNumber;
    SeatType seatType;
    SeatStatus seatStatus;
    double price;

    public Seat(String id, String seatNumber, SeatType seatType, double price)
    {
        this.id = id;
        this.seatNumber = seatNumber;
        this.seatStatus = SeatStatus.AVAILABLE;
        this.seatType = seatType;
        this.price = price;
    }

    public synchronized void book()
    {
        if(this.seatStatus != SeatStatus.AVAILABLE)
            throw new RuntimeException("Seat not available");
        this.seatStatus = SeatStatus.BOOKED;
    }

    public synchronized void release()
    {
        if(this.seatStatus == SeatStatus.BOOKED)
        {
            this.seatStatus = SeatStatus.AVAILABLE;
        }
    }

    public boolean isAvailable()
    {
        return this.seatStatus == SeatStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }
}
