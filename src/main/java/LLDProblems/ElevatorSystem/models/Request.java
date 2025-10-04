package LLDProblems.ElevatorSystem.models;

import LLDProblems.ElevatorSystem.enums.Direction;
import LLDProblems.ElevatorSystem.enums.RequestSource;

public class Request {
    int targetFloor;
    Direction direction;
    RequestSource requestSource;

    public Request(int targetFloor, Direction direction, RequestSource requestSource)
    {
        this.targetFloor = targetFloor;
        this.direction = direction;
        this.requestSource = requestSource;
    }

    public int getTargetFloor()
    {
        return targetFloor;
    }

    public Direction getDirection()
    {
        return direction;
    }

    public RequestSource getRequestSource()
    {
        return requestSource;
    }
}
