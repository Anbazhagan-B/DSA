package LLDProblems.ChessGame;

import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class ChessBoard {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chess board simulator");
        System.out.println("Enter piece type (Pawn, King, Queen) and position (e.g., 'Pawn, G1'):");
        String input = scanner.nextLine();
        String[] position = input.split(",");

        if(position.length != 2 && !validPosition(position[1]))
        {
            System.out.println("Invalid position entered");
        }

        ChessPieceType chessPieceType = ChessPieceType.valueOf(position[0].trim().toUpperCase());

        String row = position[1].trim();

        ChessPiece chessPiece = new ChessPiece(chessPieceType, row);

        List<String> moves = chessPiece.getPossibleMoves();

        StringJoiner movesPossible = new StringJoiner(", ");
        for (String string: moves)
        {
            movesPossible.add(string);
        }
        System.out.println("Possible moves from " + input + " : " + movesPossible.toString());
    }

    static boolean validPosition(String position)
    {
        char character = position.charAt(0);
        int row ;

        try {
            row = Integer.parseInt(position.substring(1));
        }
        catch (Exception ex)
        {
            throw  new RuntimeException("Invalid row");
        }

        return character >= 'A' && character <= 'H' && row >= 1 && row <= 8;
    }
}
