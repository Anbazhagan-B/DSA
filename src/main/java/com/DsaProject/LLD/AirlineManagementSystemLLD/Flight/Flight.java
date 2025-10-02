package com.DsaProject.LLD.AirlineManagementSystemLLD.Flight;

import com.DsaProject.LLD.AirlineManagementSystemLLD.Aircraft;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Seat.Seat;
import java.util.*;
import java.time.LocalDateTime;

public class Flight {
    String flightNumber;
    String source;
    String destination;
    LocalDateTime departureTime;
    LocalDateTime arrivalTime;
    FlightStatus status;
    Aircraft aircraft;
    Map<String, Seat> seats;
    List<Seat> availableSeats;

    public Flight(String flightNumber, String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Aircraft aircraft)
    {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.status = FlightStatus.ON_TIME;
        this.aircraft = aircraft;
        this.seats = new HashMap<>();
        this.availableSeats = new ArrayList<>();
    }

    public synchronized boolean isSeatAvailable(String seatNo)
    {
        Seat seat = seats.get(seatNo);
        return seat != null && seat.isBooked();
    }

    public synchronized void reserveSeat(String seatNo)
    {
        Seat seat = seats.get(seatNo);
        if(seat == null) throw  new RuntimeException("No seat exists with number" + seatNo);
        seat.reserve();
    }

    public synchronized void releaseSeat(String seatNo)
    {
        Seat seat = seats.get(seatNo);
        if(seat != null)
        {
            seat.release();
        }
    }

    public String getSource()
    {
        return this.source;
    }

    public String getDestination()
    {
        return this.destination;
    }

    public LocalDateTime getDepartureTime()
    {
        return this.departureTime;
    }

    public LocalDateTime getArrivalTime()
    {
        return this.arrivalTime;
    }
    public String getFlightNumber()
    {
        return flightNumber;
    }

    public List<Seat> getAvailableSeats()
    {
        return this.availableSeats;
    }
}
