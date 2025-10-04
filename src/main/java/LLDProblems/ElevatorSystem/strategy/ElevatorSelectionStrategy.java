package LLDProblems.ElevatorSystem.strategy;

import LLDProblems.ElevatorSystem.Elevator;
import LLDProblems.ElevatorSystem.models.Request;

import java.util.List;

public interface ElevatorSelectionStrategy {
    public Elevator selectElevator(List<Elevator> elevatorList, Request request);
}
