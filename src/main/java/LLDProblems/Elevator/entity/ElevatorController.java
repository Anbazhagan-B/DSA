package LLDProblems.Elevator.entity;

import com.DsaProject.IntPack.Executor;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ElevatorController {
    List<Elevator> elevators;
    ExecutorService elevatorService ;
    int numOfElevators;
    public ElevatorController(int numOfElevators)
    {
        this.numOfElevators = numOfElevators;
        this.elevators = new ArrayList<>();
        for(int i = 0 ; i < numOfElevators; i++)
        {
            elevators.add(new Elevator(i + 1));
        }
        elevatorService = Executors.newFixedThreadPool(numOfElevators);

        for(Elevator elevator : elevators)
        {
            elevatorService.submit(() ->
            {
                while(true)
                {
                    elevator.move();
                    Thread.sleep(1000);
                }
            });
        }
    }

    private Elevator bestElevator(int floor, Direction direction){
        Elevator bestElevator = null;
        Integer minDistance = Integer.MAX_VALUE;
        for(Elevator elevator : elevators)
        {
            int distance = calculateDistance(floor, elevator, direction);
            if(distance < minDistance)
            {
                minDistance = distance;
                bestElevator = elevator;
            }
        }
        return bestElevator;
    }

    public int calculateDistance(int floor, Elevator elevator, Direction direction)
    {
        Integer elevatorFloor = elevator.currentFloor;
        Direction elevatorDirection = elevator.direction;
        Status elevatorStatus = elevator.status;

        if(elevatorStatus == Status.STOPPED)
            return Math.abs(floor - elevatorFloor);

        if((elevatorDirection  == Direction.UP && direction == Direction.UP && floor >= elevatorFloor)
                || elevatorDirection  == Direction.DOWN && direction == Direction.DOWN && floor >= elevatorFloor)
        {
            return Math.abs(floor - elevatorFloor);
        }


        return Math.abs(floor - elevatorFloor);
    }

    public void requestElevator(int floor, Direction direction)
    {
        Elevator bestElevator = bestElevator(floor, direction);
        if(bestElevator != null)
        {
            bestElevator.addRequest(floor);
        }
    }

    public void addDestination(int elevatorId, int floorId)
    {
        if(validElevatorId(elevatorId - 1))
        {
            elevators.get(elevatorId - 1).addRequest(floorId);
        }
    }

    boolean validElevatorId(int elevatorId)
    {
        return elevatorId >= 0 && elevatorId < numOfElevators;
    }

    public void emergencyStop(int elevatorId)
    {
        if(validElevatorId(elevatorId - 1))
        {
            elevators.get(elevatorId - 1).emergencyStop();
        }
    }

    public void setElevatorMaintenance(int elevatorId, Boolean maintenance) {
        if (validElevatorId(elevatorId - 1)) {
            elevators.get(elevatorId - 1).setMaintenanceMode(maintenance);
        }
    }
}
