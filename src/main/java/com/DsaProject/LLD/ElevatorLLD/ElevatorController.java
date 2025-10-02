package com.DsaProject.LLD.ElevatorLLD;

import java.util.*;

public class ElevatorController {
    List<Elevator> elevators;

    public ElevatorController(int numOfElevators, int capacity)
    {
        elevators= new ArrayList<>();
        for(int i = 0; i< numOfElevators; i++)
        {
            Elevator elevator = new Elevator(i + 1, capacity);
            elevators.add(elevator);
            new Thread(elevator::run).start();
        }
    }

    public void requestElevator(int source, int destination)
    {
        Elevator optimalElevator = findOptimalElevator(source, destination);
        optimalElevator.addRequest(new Request(source, destination));
    }

    public Elevator findOptimalElevator(int source, int destination)
    {
        Elevator optimalElevator = null;

        int minDistance = Integer.MAX_VALUE;

        Direction direction = (source - destination) > 0 ? Direction.DOWN : Direction.UP;

        List<Elevator> currentDirectionElevators = elevators.stream().anyMatch(elevator -> elevator.getCurrentDirection() == direction) ?
                elevators.stream().filter(elevator -> elevator.getCurrentDirection() == direction).toList() : elevators;

        for (Elevator elevator : currentDirectionElevators)
        {
            int distance = source - elevator.getCurrentFloor();
            if(distance < minDistance)
            {
                minDistance = distance;
                optimalElevator = elevator;
            }
        }
        return optimalElevator;
    }
}
