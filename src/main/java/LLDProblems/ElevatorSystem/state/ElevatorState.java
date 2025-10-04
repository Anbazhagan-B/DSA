package LLDProblems.ElevatorSystem.state;

import LLDProblems.ElevatorSystem.Elevator;
import LLDProblems.ElevatorSystem.enums.Direction;
import LLDProblems.ElevatorSystem.models.Request;

public interface ElevatorState {
    Direction getDirection();
    void addRequest(Elevator elevator, Request request);
    void move(Elevator elevator);
}
