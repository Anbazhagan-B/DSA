package com.DsaProject.LLD.SnakeAndLadderLLD.models;

import java.util.*;

public class Board {
    int size;
    Map<Integer, Integer> snakesAndLadders = new HashMap<>();

    public Board(int size, List<BoardEntity> entities)
    {
        this.size = size;
        this.snakesAndLadders = new HashMap<>();

        for (BoardEntity boardEntity : entities)
        {
            this.snakesAndLadders.put(boardEntity.getStart(), boardEntity.getEnd());
        }
    }

    public int getSize()
    {
        return size;
    }

    public int getFinalPosition(int startPosition) {
        return this.snakesAndLadders.get(startPosition);
    }
}
