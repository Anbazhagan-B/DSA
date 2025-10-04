package LLDProblems.ElevatorSystem;

import LLDProblems.ElevatorSystem.enums.Direction;

public class ElevatorSystemDemo {
    public static void main(String[] args)
    {
        ElevatorSystem elevatorSystem = ElevatorSystem.getInstance(5);
        elevatorSystem.requestElevator(Direction.UP, 5);
        elevatorSystem.requestElevator(Direction.DOWN, 3);
        elevatorSystem.requestElevator(Direction.UP, 8);
        elevatorSystem.requestElevator(Direction.UP, 2);

        elevatorSystem.start();
    }
}
