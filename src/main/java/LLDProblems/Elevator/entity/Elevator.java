package LLDProblems.Elevator.entity;

import java.util.*;

public class Elevator {
    public int elevatorId;
    public int currentFloor;
    public Direction direction;
    public Status status;
    private Set<Integer> requests;
    public PriorityQueue<Integer> upFloors;
    public PriorityQueue<Integer> downFloors;

    public Elevator(int elevatorId)
    {
        this.elevatorId = elevatorId;
        this.currentFloor = 0;
        this.direction = Direction.IDLE;
        this.status = Status.STOPPED;
        this.upFloors = new PriorityQueue<>();
        this.downFloors = new PriorityQueue<>(Collections.reverseOrder());
        this.requests = new HashSet<>();
    }

    public void moveFloor()
    {
        if(direction == Direction.UP)
        {
            currentFloor++;
        }
        else if(direction == Direction.DOWN)
        {
            currentFloor--;
        }
    }

    public void addRequest(int floor)
    {
        if(!requests.contains(floor))
        {
            if(floor < currentFloor)
            {
                upFloors.add(floor);
            }
            else
            {
                downFloors.add(floor);
            }
        }
        requests.add(floor);
        determineDirection();
    }

    public void determineDirection()
    {
        if(upFloors.isEmpty() && downFloors.isEmpty())
        {
            direction = Direction.IDLE;
            status = Status.STOPPED;
        }
        else if(direction == Direction.UP && upFloors.isEmpty())
        {
            direction = downFloors.isEmpty() ? Direction.IDLE : Direction.DOWN;
        }
        else if(direction == Direction.DOWN && downFloors.isEmpty())
        {
            direction = upFloors.isEmpty() ? Direction.IDLE : Direction.UP;
        }
        else if(direction != Direction.IDLE)
        {
            direction = upFloors.isEmpty() ? Direction.DOWN : Direction.UP;
        }

        if(direction != Direction.IDLE)
            status = Status.RUNNING;
    }

    public void move()
    {
        if(status != Status.RUNNING)
            return;

        if(direction == Direction.UP)
        {
            currentFloor++;
            if(currentFloor == upFloors.peek())
            {
                upFloors.poll();
                requests.remove(currentFloor);
            }
        }
        else if(direction == Direction.DOWN)
        {
            currentFloor--;
            if(currentFloor == downFloors.peek())
            {
                downFloors.poll();
                requests.remove(currentFloor);
            }
        }

        determineDirection();
    }

    public void setMaintenanceMode(boolean maintenanceMode)
    {
        direction = Direction.IDLE;
        status = maintenanceMode ? Status.MAINTENANCE : Status.STOPPED;
        System.out.printf("Elevator %d has maintenance mode set as", elevatorId);
        if(maintenanceMode)
        {
            upFloors.clear();
            downFloors.clear();
            requests.clear();
        }
    }

    public void emergencyStop()
    {
        System.out.printf("Elevator %d is stopped emergency", elevatorId);
        direction = Direction.IDLE;
        status = Status.STOPPED;
    }
}
