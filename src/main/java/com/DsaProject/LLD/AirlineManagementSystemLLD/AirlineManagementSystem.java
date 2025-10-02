package com.DsaProject.LLD.AirlineManagementSystemLLD;

import com.DsaProject.LLD.AirlineManagementSystemLLD.Booking.Booking;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Booking.BookingManager;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Flight.Flight;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Flight.FlightSearch;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Flight.FlightStatus;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Payment.Payment;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Payment.PaymentProcessor;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Payment.PaymentStatus;
import com.DsaProject.LLD.AirlineManagementSystemLLD.Seat.Seat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class AirlineManagementSystem {
    Map<String, Flight> flights;
    Map<String, Aircraft> airCrafts;
    Map<String, Passenger> passengers;

    FlightSearch flightSearch;
    BookingManager bookingManager;
    PaymentProcessor paymentProcessor;

    public AirlineManagementSystem()
    {
        this.flights = new HashMap<>();
        this.passengers = new HashMap<>();
        this.airCrafts = new HashMap<>();
        this.flightSearch = new FlightSearch();
        this.bookingManager = new BookingManager();
        this.paymentProcessor = new PaymentProcessor();
    }

    public Passenger addPassenger(String name, String email)
    {
        Passenger passenger = new Passenger(name, email);
        passengers.put(passenger.getId(), passenger);

        return passenger;
    }

    public Aircraft addAircraft(String tailNumber, String model, int totalSeats)
    {
        Aircraft aircraft = new Aircraft(tailNumber, model, totalSeats);
        airCrafts.put(aircraft.getTailNumber(), aircraft);
        return aircraft;
    }

    public Flight addFlight(String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Aircraft aircraft)
    {
        String flightNumber = UUID.randomUUID().toString();
        Flight flight = new Flight(flightNumber, source, destination, departureTime, arrivalTime, aircraft);
        flights.put(flightNumber, flight);
        flightSearch.addFlight(flight);
        return flight;
    }

    public List<Flight> searchFlights(String source, String destination, LocalDate departureTime)
    {
        return flightSearch.searchFlight(source, destination, departureTime);
    }

    public Booking bookFlight(String flightNumber, String passengerId, Seat seat, double price)
    {
        Flight flight = flights.get(flightNumber);
        Passenger passenger = passengers.get(passengerId);
        return bookingManager.createBooking(passenger, flight, seat, price);
    }

    public void cancelBooking(String bookingNumber)
    {
        bookingManager.cancelBooking(bookingNumber);
    }

    public void processPayment(Payment payment)
    {
        paymentProcessor.processPayment(payment);
    }
}
