package LLDProblems.ElevatorSystem;

import LLDProblems.ElevatorSystem.enums.Direction;
import LLDProblems.ElevatorSystem.enums.RequestSource;
import LLDProblems.ElevatorSystem.models.Request;
import LLDProblems.ElevatorSystem.observer.ElevatorDisplay;
import LLDProblems.ElevatorSystem.strategy.ElevatorSelectionStrategy;
import LLDProblems.ElevatorSystem.strategy.NearestSelectionStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorSystem {
    static ElevatorSystem INSTANCE;
    final  ExecutorService executorService;
    final  Map<Integer, Elevator> elevators;
    final ElevatorSelectionStrategy selectionStrategy;

    public ElevatorSystem(int numberOfElevators)
    {
        this.selectionStrategy = new NearestSelectionStrategy();
        this.executorService = Executors.newFixedThreadPool(numberOfElevators);

        this.elevators = new HashMap<>();
        ElevatorDisplay elevatorDisplay = new ElevatorDisplay();

        for (int i = 1 ; i <= numberOfElevators; i++)
        {
            Elevator elevator = new Elevator(i);
            elevator.addObservers(elevatorDisplay);
            this.elevators.put(i, elevator);
        }
    }

    public void start()
    {
        for(Elevator elevator : elevators.values())
        {
            executorService.submit(elevator);
        }
    }

    public static synchronized ElevatorSystem getInstance(int numberOfElevators)
    {
        if(INSTANCE == null)
        {
            INSTANCE = new ElevatorSystem(numberOfElevators);
        }
        return INSTANCE;
    }

    public void shutdown()
    {
        System.out.println("Stopping Elevator System");
        for(Elevator elevator : elevators.values())
        {
            elevator.stopElevator();
        }
        this.executorService.shutdown();
    }

    public void selectFloor(int elevatorId, int requestFloor)
    {
        System.out.println("Internal Request to" + requestFloor + " for Elevator" + elevatorId);
        Request request = new Request(requestFloor, Direction.IDLE, RequestSource.INTERNAL);

        Elevator elevator = elevators.get(elevatorId);

        if(elevator != null)
        {
            elevator.addRequest(request);
        }
        else
        {
            System.out.println("Invalid Elevator");
        }
    }

    public void requestElevator(Direction direction, int floorNumber)
    {
        System.out.println("External Request to - " + floorNumber + " for Direction" + direction);
        Request request = new Request(floorNumber, direction, RequestSource.INTERNAL);

        Elevator elevator = this.selectionStrategy.selectElevator(new ArrayList<>(elevators.values()), request);

        if(elevator != null)
        {
            elevator.addRequest(request);
        }
        else
        {
            System.out.println("Invalid Elevator");
        }

    }
}
