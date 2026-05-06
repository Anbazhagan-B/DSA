package HashMap;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem: Valid Sudoku
 * Difficulty: Medium
 * Source: LeetCode #36 (NeetCode 150)
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated:
 *   1) Each row must contain the digits 1-9 without repetition.
 *   2) Each column must contain the digits 1-9 without repetition.
 *   3) Each of the nine 3x3 sub-boxes must contain the digits 1-9 without repetition.
 * Empty cells are filled with '.'. The board does not have to be solvable; only the
 * partially-filled state needs to satisfy the three rules.
 *
 * Approach:
 * Single pass over all 81 cells. For each filled digit, encode three "seen" tokens â
 * "r{row}{digit}", "c{col}{digit}", "b{boxIdx}{digit}" where boxIdx = (row/3)*3 + col/3 â
 * and insert into one HashSet. If any insertion fails, the board is invalid.
 * One pass, one set, no per-row/column/box temporary structures.
 *
 * Time:  O(81) = O(1) since the board is fixed-size 9x9.
 * Space: O(81) = O(1) for the seen set.
 */
public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                int boxIdx = (r / 3) * 3 + (c / 3);
                if (!seen.add("r" + r + ch) ||
                    !seen.add("c" + c + ch) ||
                    !seen.add("b" + boxIdx + ch)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] valid = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(valid)); // true

        char[][] dupTopLeft = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(dupTopLeft)); // false (two 8s in column 0)
    }
}
