package LLDProblems.SnakeLadder;

public class Client {
    public static void main(String[] args)
    {
        SnakeLadderController snakeLadderController = SnakeLadderController.getInstance();
        snakeLadderController.StartGame();
    }
}
