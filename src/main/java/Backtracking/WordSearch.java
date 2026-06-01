package Backtracking;

/*
 * Problem: Word Search
 * Difficulty: Medium
 * Source: LeetCode #79 / NeetCode 150
 *
 * Given an m x n grid of characters "board" and a string "word", return true if
 * "word" exists in the grid. The word can be built from letters of sequentially
 * adjacent cells, where adjacent cells are horizontally or vertically neighbouring.
 * The same cell may not be used more than once.
 */

/*
 * Approach:
 * Try to start the word at every cell, then run DFS with backtracking: if the
 * current cell matches the current letter, mark it used (overwrite temporarily),
 * recurse into the four neighbours for the next letter, then restore the cell on
 * the way back. We succeed once the whole word index has been consumed.
 *
 * Time Complexity:  O(m * n * 4^L), L = word length (4 directions per character)
 * Space Complexity: O(L) for the recursion depth
 */
public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, String word, int idx, int r, int c) {
        if (idx == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) return false;
        if (board[r][c] != word.charAt(idx)) return false;

        char tmp = board[r][c];
        board[r][c] = '#'; // mark as visited so it can't be reused
        boolean found = dfs(board, word, idx + 1, r + 1, c)
                     || dfs(board, word, idx + 1, r - 1, c)
                     || dfs(board, word, idx + 1, r, c + 1)
                     || dfs(board, word, idx + 1, r, c - 1);
        board[r][c] = tmp;  // restore for other paths (backtrack)
        return found;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "ABCCED")); // true
        System.out.println(exist(board, "SEE"));    // true
        System.out.println(exist(board, "ABCB"));   // false
    }
}
