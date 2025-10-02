package com.DsaProject.LLD.SnakeAndLadderLLD.models;

public class BoardEntity {
    int start;
    int end;

    public BoardEntity(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    public int getStart()
    {
        return this.start;
    }

    public int getEnd()
    {
        return this.end;
    }
}
