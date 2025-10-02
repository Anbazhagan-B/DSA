package com.DsaProject.LLD.ChessGameLLD;

public class XClient {
    public static void main(String[] args) {
        ChessGame chessGame = new ChessGame();
        chessGame.setPlayers("Alice", "Bob");
        chessGame.start();
    }
}
