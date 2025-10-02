package LLDProblems.SnakeLadder;

import java.util.*;

public class SnakeLadderController {
    Map<Integer, Integer> snakes = new HashMap<>();
    Map<Integer, Integer> ladders = new HashMap<>();
    public Integer MAX_BOARD_SIZE = 100;
    int numberOfPlayers ;
    static SnakeLadderController instance;
    public SnakeLadderController()
    {
        numberOfPlayers = 0;
        snakes = new HashMap<>();
        snakes.put(33, 10);
        snakes.put(83, 10);
        ladders = new HashMap<>();
        ladders.put(3, 100);
        ladders.put(8, 100);
        ladders.put(10, 100);
        ladders.put(35, 100);
    }

    public void StartGame()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to snake ladder game");

        System.out.println("Enter number of players");
        numberOfPlayers = scanner.nextInt();
        Queue<Player> players = new LinkedList<>();
        for(int i = 0; i < numberOfPlayers; i++)
        {
            System.out.printf("Enter the name of Player %d ", i + 1);
            String name = scanner.next();
            players.add(new Player(name));
        }

        boolean gameStopped = false;
        Random random = new Random();
        while (!gameStopped)
        {
            Player currentPlayer = players.poll();

            System.out.printf("%s press Enter to roll the dice", currentPlayer.getName());

            scanner.nextLine();
            scanner.nextLine();

            int diceRolls = random.nextInt(6) + 1;

            int newPosition = diceRolls + currentPlayer.getPosition();

            if(newPosition > MAX_BOARD_SIZE)
            {
                System.out.printf("%s possible moves lies between{%d - %d}", currentPlayer.name, MAX_BOARD_SIZE - newPosition, MAX_BOARD_SIZE);
                players.add(currentPlayer);
                continue;
            }

            if(snakes.containsKey(newPosition))
            {
                int tailPosition = snakes.get(newPosition);
                System.out.printf("%s caught by snake, Ended up at %d", currentPlayer.name, tailPosition);
                newPosition = tailPosition;
            }
            else if(ladders.containsKey(newPosition))
            {
                int ladderPosition = ladders.get(newPosition);
                System.out.printf("%s Up in the game!, Raised up by ladder at %d", currentPlayer.name, ladderPosition);
                newPosition = ladderPosition;
            }

            currentPlayer.setPosition(newPosition);

            if(newPosition == MAX_BOARD_SIZE)
            {
                System.out.printf(" %s won the game, you are reached to %d \n", currentPlayer.name, newPosition, MAX_BOARD_SIZE);
                gameStopped = true;
            }
            else
            {
                players.add(currentPlayer);
                System.out.printf("%s better luck next time, %d position is not reached to %d \n", currentPlayer.name, newPosition, MAX_BOARD_SIZE);
            }
        }

        scanner.close();
    }

    public static SnakeLadderController getInstance()
    {
        if(instance == null)
        {
            instance = new SnakeLadderController();
        }

        return instance;
    }

}
