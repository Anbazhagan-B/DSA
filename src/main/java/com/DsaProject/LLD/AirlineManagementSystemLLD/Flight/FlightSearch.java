package com.DsaProject.LLD.AirlineManagementSystemLLD.Flight;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FlightSearch {
    List<Flight> flights;

    public FlightSearch()
    {
        this.flights = new ArrayList<>();
    }

    public void addFlight(Flight flight)
    {
        this.flights.add(flight);
    }

    public List<Flight> searchFlight(String source, String destination, LocalDate date)
    {
        return this.flights.stream().filter(flight ->
                flight.getSource().equalsIgnoreCase(source) && flight.getDestination().equalsIgnoreCase(destination) &&
                flight.getDepartureTime().toLocalDate().equals(date)).toList();
    }
}
