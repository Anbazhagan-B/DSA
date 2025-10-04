package LLDProblems.ElevatorSystem;

import LLDProblems.ElevatorSystem.enums.Direction;
import LLDProblems.ElevatorSystem.models.Request;
import LLDProblems.ElevatorSystem.observer.ElevatorDisplay;
import LLDProblems.ElevatorSystem.observer.ElevatorObserver;
import LLDProblems.ElevatorSystem.state.ElevatorState;
import LLDProblems.ElevatorSystem.state.IdleState;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Elevator implements Runnable {
    int id;
    AtomicInteger currentFloor;
    List<ElevatorObserver> observers;
    ElevatorState state;
    boolean isRunning;
    TreeSet<Integer> upRequest;
    TreeSet<Integer> downRequest;

    public Elevator(int id)
    {
        this.id = id;
        currentFloor = new AtomicInteger(0);
        observers = new ArrayList<>();
        state = new IdleState();
        isRunning = true;
        upRequest = new TreeSet<>();
        downRequest = new TreeSet<>((a, b) -> b.compareTo(a));
    }

    public void addObservers(ElevatorObserver elevatorObserver)
    {
        observers.add(elevatorObserver);
        elevatorObserver.update(this);
    }

    public void notifyObservers()
    {
        for(ElevatorObserver observer : observers)
        {
            observer.update(this);
        }
    }

    public synchronized void addRequest(Request request)
    {
        this.state.addRequest(this, request);
    }

    public int getId()
    {
        return this.id;
    }

    public Direction getDirection()
    {
        return state.getDirection();
    }

    public int getCurrentFloor()
    {
        return currentFloor.intValue();
    }

    public void setCurrentFloor(Integer floor)
    {
        this.currentFloor.set(floor);
        this.notifyObservers();
    }

    public TreeSet<Integer> getUpRequests()
    {
        return upRequest;
    }

    public TreeSet<Integer> getDownRequests()
    {
        return downRequest;
    }

    public boolean isRunning() { return isRunning; };

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState elevatorState)
    {
        this.state = elevatorState;
    }

    public void stopElevator()
    {
        this.isRunning = false;
    }

    public TreeSet<Integer> getUpRequest()
    {
        return this.upRequest;
    }

    public TreeSet<Integer> getDownRequest()
    {
        return this.downRequest;
    }

    public void move(){this.state.move(this);}

    @Override
    public void run() {
        while (isRunning)
        {
            move();
            try
            {
                Thread.sleep(1000);
            }
            catch (Exception exception)
            {
                Thread.currentThread().interrupt();
                isRunning = false;
            }
        }
    }
}
