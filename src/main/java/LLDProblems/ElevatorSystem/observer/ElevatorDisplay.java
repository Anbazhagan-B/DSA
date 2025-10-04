package LLDProblems.ElevatorSystem.observer;

import LLDProblems.ElevatorSystem.Elevator;

public class ElevatorDisplay implements ElevatorObserver{
    @Override
    public void update(Elevator elevator) {
        System.out.println("[Display] Elevator "+ elevator.getId() +", current floor - "+  elevator.getCurrentFloor()+", current direction -" +  elevator.getDirection() );
    }
}
