package LLDProblems.SnakeLadder;

public class Player {
    int position;
    String name;

    public Player(String name)
    {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName()
    {
        return this.name;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
