package LLDProblems.ElevatorSystem.state;

import LLDProblems.ElevatorSystem.Elevator;
import LLDProblems.ElevatorSystem.enums.Direction;
import LLDProblems.ElevatorSystem.enums.RequestSource;
import LLDProblems.ElevatorSystem.models.Request;

public class MovingUpState implements ElevatorState{
    @Override
    public Direction getDirection() {
        return Direction.UP;
    }

    @Override
    public void addRequest(Elevator elevator, Request request) {
        if(request.getRequestSource() == RequestSource.INTERNAL)
        {
            if(request.getTargetFloor() > elevator.getCurrentFloor())
            {
                elevator.getUpRequests().add(request.getTargetFloor());
            }
            else
            {
                elevator.getDownRequests().add(request.getTargetFloor());
            }
            return;
        }

        if(request.getDirection() == Direction.UP && request.getTargetFloor() >= elevator.getCurrentFloor())
        {
            elevator.getUpRequests().add(request.getTargetFloor());
        }
        else if(request.getDirection() == Direction.DOWN)
        {
            elevator.getDownRequests().add(request.getTargetFloor());
        }
    }

    @Override
    public void move(Elevator elevator) {
        if(elevator.getUpRequests().isEmpty())
        {
            elevator.setState(new IdleState());
            return;
        }

        int nextFloor = elevator.getUpRequests().first();

        elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);

        if(elevator.getCurrentFloor() == nextFloor)
        {
            System.out.println("Elevator Arrived at requested floor" + nextFloor);
            elevator.getUpRequests().pollFirst();
        }

        if(elevator.getUpRequests().isEmpty())
        {
            elevator.setState(new IdleState());
        }
    }
}
