/**
 * Problem: Rotting Oranges
 * Difficulty: Medium
 * Source: LeetCode #994 / NeetCode 150
 *
 * Problem Statement:
 * You are given an m x n grid where each cell is 0 (empty), 1 (fresh orange), or
 * 2 (rotten orange). Every minute, any fresh orange 4-directionally adjacent to a
 * rotten orange becomes rotten. Return the minimum number of minutes until no fresh
 * orange remains. If it is impossible, return -1.
 *
 * Approach:
 * Multi-source BFS starting simultaneously from all initially rotten oranges.
 * Track the count of fresh oranges. Each BFS level = 1 minute elapsed.
 * After BFS completes, if any fresh orange remains return -1, else return minutes.
 * The key insight: all rotten sources spread in parallel, so BFS naturally models this.
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) queue.offer(new int[]{r, c});
                else if (grid[r][c] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int nr = cell[0] + d[0], nc = cell[1] + d[1];
                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        fresh--;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return fresh == 0 ? minutes - 1 : -1;
    }

    public static void main(String[] args) {
        RottenOranges solution = new RottenOranges();

        // Example 1: [[2,1,1],[1,1,0],[0,1,1]] -> Expected: 4
        System.out.println(solution.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}})); // 4

        // Example 2: [[2,1,1],[0,1,1],[1,0,1]] -> Expected: -1 (isolated orange)
        System.out.println(solution.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}})); // -1

        // Example 3: [[0,2]] -> Expected: 0 (no fresh oranges)
        System.out.println(solution.orangesRotting(new int[][]{{0,2}})); // 0

        // Example 4: [[1,2]] -> Expected: 1
        System.out.println(solution.orangesRotting(new int[][]{{1,2}})); // 1
    }
}
