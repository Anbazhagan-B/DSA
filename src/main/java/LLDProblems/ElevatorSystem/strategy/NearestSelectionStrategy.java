package LLDProblems.ElevatorSystem.strategy;

import LLDProblems.ElevatorSystem.Elevator;
import LLDProblems.ElevatorSystem.enums.Direction;
import LLDProblems.ElevatorSystem.models.Request;

import java.util.List;

public class NearestSelectionStrategy implements ElevatorSelectionStrategy{
    @Override
    public Elevator selectElevator(List<Elevator> elevatorList, Request request) {
        Elevator beatElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for (Elevator elevator: elevatorList)
        {
            if(isSuitable(elevator, request))
            {
                int distance = Math.abs(elevator.getCurrentFloor() - request.getTargetFloor());

                if(distance < minDistance)
                {
                    minDistance = distance;
                    beatElevator = elevator;
                }
            }
        }

        return beatElevator;
    }

    boolean isSuitable(Elevator elevator, Request request)
    {
        if(elevator.getDirection() == Direction.IDLE)
        {
            return  true;
        }

        if(elevator.getDirection() == Direction.UP && elevator.getCurrentFloor() <= request.getTargetFloor())
        {
            return true;
        }
        else if(elevator.getDirection() == Direction.DOWN && elevator.getCurrentFloor() >= request.getTargetFloor())
        {
            return true;
        }

        return false;
    }
}
