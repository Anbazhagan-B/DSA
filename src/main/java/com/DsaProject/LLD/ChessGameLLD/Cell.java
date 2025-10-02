package com.DsaProject.LLD.ChessGameLLD;

import com.DsaProject.LLD.ChessGameLLD.pieces.Piece;

public class Cell {
    int row, col;
    Piece piece;

    public Cell(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public boolean isOccupied()
    {
        return piece != null;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
