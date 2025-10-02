package com.DsaProject.LLD.ChessGameLLD.pieces;

import com.DsaProject.LLD.ChessGameLLD.Board;
import com.DsaProject.LLD.ChessGameLLD.Cell;
import com.DsaProject.LLD.ChessGameLLD.Color;

import java.util.Map;

public class Bishop extends Piece{
    public Bishop(Color color)
    {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        int rowDiff = Math.abs(to.getRow() - from.getRow());
        int colDiff = Math.abs(to.getCol() - from.getCol());
        return (rowDiff == colDiff);
    }

}
