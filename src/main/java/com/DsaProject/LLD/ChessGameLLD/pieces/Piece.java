package com.DsaProject.LLD.ChessGameLLD.pieces;

import com.DsaProject.LLD.ChessGameLLD.*;
import com.DsaProject.LLD.ChessGameLLD.Color;

import java.awt.*;

public abstract class Piece {
    Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public abstract boolean canMove(Board board, Cell from, Cell to);

    public Color getColor()
{
    return color;
}
}
