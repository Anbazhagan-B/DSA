package com.DsaProject.LLD.ChessGameLLD;

public class Player {
    String name;
    Color color;

    public Player(String name, Color color)
    {
        this.color = color;
        this.name = name;
    }

    public Color getColor()
    {
        return color;
    }

    public String getName()
    {
        return name;
    }
}
