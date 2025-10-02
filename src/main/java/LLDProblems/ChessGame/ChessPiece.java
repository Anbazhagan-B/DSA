package LLDProblems.ChessGame;

import java.util.*;

public class ChessPiece {
    ChessPieceType type;
    String position;

    public ChessPiece(ChessPieceType type, String position)
    {
        this.type = type;
        this.position = position;
    }

    public List<String> getPossibleMoves()
    {
        switch (type)
        {
            case PAWN:
                return getValidatePawnMoves();
            case KING :
                return getValidateKingMoves();
            case QUEEN:
                return getValidateQueenMoves();
        }

        return new ArrayList<>();
    }

    public List<String> getValidatePawnMoves()
    {
        List<String> moves = new ArrayList<>();
        char col = position.charAt(0);
        int row = Integer.parseInt(position.substring(1));
        int newRow = row + 1;

        if(newRow <= 8)
        {
            moves.add(col + String.valueOf(newRow));
        }
        return moves;
    }

    public List<String> getValidateKingMoves() {
        List<String> moves = new ArrayList<>();
        char col = position.charAt(0);
        int row = Integer.parseInt(position.substring(1));

        int[] colDirectories = new int[] {-1,   0,   1,  -1,  1,  -1,  0,  1};
        int[] rowDirectories = new int[] {-1,  -1,  -1,   0,   0,  1,  1,  1};

        for(int i =0; i <= 8; i++)
        {
            char colValue = (char)(col + colDirectories[i]);
            int rowPosition = rowDirectories[i];

            if(isValidMove(colValue, rowPosition))
            {
                moves.add(String.valueOf(colValue) + rowPosition);
            }
        }
        return moves;
    }

    public List<String> getValidateQueenMoves() {
        List<String> moves = new ArrayList<>();
        char col = position.charAt(0);
        int row = Integer.parseInt(position.substring(1));

        for(char c = 'A'; c <= 'H'; c++)
        {
            if(c != col)
            {
                moves.add(String.valueOf(c) + row);
            }
        }

        for(int i = 1; i <= 8; i++)
        {
            if(i != row)
            {
                moves.add(col + String.valueOf(i));
            }
        }

        for(int i = 1; i <= 8; i++)
        {
            char newCol1 = (char)(col - i);
            int newRow1 = row - i;

            if(isValidMove(newCol1, newRow1))
                moves.add(String.valueOf(newCol1) + newRow1);

            char newCol2 = (char)(col - i);
            int newRow2 = row + i;

            if(isValidMove(newCol2, newRow2))
                moves.add(String.valueOf(newCol2) + newRow2);

            char newCol3 = (char)(col + i);
            int newRow3 = row - i;

            if(isValidMove(newCol3, newRow3))
                moves.add(String.valueOf(newCol3) + newRow3);

            char newCol4 = (char)(col + i);
            int newRow4 = row + i;

            if(isValidMove(newCol4, newRow4))
                moves.add(String.valueOf(newCol4) + newRow4);

        }

        return moves;
    }

    boolean isValidMove(char col , int row)
    {
        return col >= 'A' && col <= 'H' && row >= 1 && row < 8;
    }

}
