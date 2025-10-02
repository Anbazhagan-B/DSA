package com.DsaProject.LLD.ChessGameLLD;

public class Move {
    Cell start;
    Cell end;

    public Move(Cell start, Cell end)
    {
        this.start = start;
        this.end = end;
    }

    public Cell getStart()
    {
        return start;
    }

    public Cell getEnd() {
        return end;
    }
}
