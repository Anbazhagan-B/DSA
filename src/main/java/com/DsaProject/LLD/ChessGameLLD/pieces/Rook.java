package com.DsaProject.LLD.ChessGameLLD.pieces;


import com.DsaProject.LLD.ChessGameLLD.*;
import com.DsaProject.LLD.ChessGameLLD.Color;

public class Rook extends Piece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public boolean canMove(Board board, Cell from, Cell to) {
        return (from.getRow() == to.getRow() || from.getCol() == to.getCol());
    }
}
