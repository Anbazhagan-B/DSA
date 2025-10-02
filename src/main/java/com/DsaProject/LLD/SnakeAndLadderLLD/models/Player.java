package com.DsaProject.LLD.SnakeAndLadderLLD.models;

public class Player {
    String name;
    int position;

    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPosition()
    {
        return this.position;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }
}
