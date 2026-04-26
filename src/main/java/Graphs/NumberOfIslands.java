package Graphs;

/*
 * Problem: Number of Islands
 * Difficulty: Medium
 * Source: LeetCode #200 (NeetCode 150 - Graphs)
 *
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands. An island is surrounded by water and is formed by
 * connecting adjacent lands horizontally or vertically. You may assume all four edges
 * of the grid are surrounded by water.
 *
 * Approach (DFS flood fill):
 * Iterate over every cell. When a '1' is found, increment the island counter and run a
 * DFS that "sinks" the entire connected component by marking visited land cells as '0'.
 * Each cell is visited at most once across the whole algorithm.
 *
 * Time Complexity:  O(m * n) - every cell is visited at most once.
 * Space Complexity: O(m * n) - worst-case recursion depth (a single giant island).
 */
public class NumberOfIslands {

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c, rows, cols);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] != '1') return;
        grid[r][c] = '0'; // mark as visited
        dfs(grid, r + 1, c, rows, cols);
        dfs(grid, r - 1, c, rows, cols);
        dfs(grid, r, c + 1, rows, cols);
        dfs(grid, r, c - 1, rows, cols);
    }

    public static void main(String[] args) {
        char[][] g1 = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };
        System.out.println("Grid 1 -> Islands: " + numIslands(g1)); // 1

        char[][] g2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };
        System.out.println("Grid 2 -> Islands: " + numIslands(g2)); // 3

        char[][] g3 = {
            {'1','0','1','0','1'},
            {'0','0','0','0','0'},
            {'1','0','1','0','1'}
        };
        System.out.println("Grid 3 -> Islands: " + numIslands(g3)); // 6
    }
}
