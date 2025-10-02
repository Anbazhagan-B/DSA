package LLDProblems.Elevator;

import java.util.*;
import LLDProblems.Elevator.entity.Direction;
import LLDProblems.Elevator.entity.ElevatorController;

public class Client {
    public static void main(String[] args)
    {
        ElevatorController elevatorController = new ElevatorController(5);

        elevatorController.requestElevator(2, Direction.UP);
        elevatorController.requestElevator(1, Direction.DOWN);

        elevatorController.emergencyStop(1);
    }

    public static void closestNumbers(List<Integer> numbers) {
        Collections.sort(numbers);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.size() - 1; i++) {
            int diff = numbers.get(i + 1) - numbers.get(i);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i + 1) - numbers.get(i) == minDiff) {
                System.out.print(numbers.get(i) + " " + numbers.get(i + 1));
                System.out.println();
            }
        }
    }
}
