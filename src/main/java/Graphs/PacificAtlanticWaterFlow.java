package Graphs;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Pacific Atlantic Water Flow
 * Difficulty: Medium
 * Source: LeetCode #417 / NeetCode 150
 *
 * There is an m x n rectangular island that borders both the Pacific Ocean (the
 * top and left edges) and the Atlantic Ocean (the bottom and right edges). Given
 * an m x n matrix "heights", rain water can flow from a cell to a neighbouring
 * cell (up/down/left/right) whose height is less than or equal to the current
 * cell's height. Return every coordinate from which water can reach BOTH oceans.
 */

/*
 * Approach:
 * Reverse the flow. Instead of asking "can this cell reach an ocean?", start a DFS
 * from each ocean's border cells and move to neighbours with GREATER OR EQUAL
 * height (water could have flowed down into the border). Cells reachable from the
 * Pacific borders and from the Atlantic borders are recorded in two boolean grids;
 * the answer is the set of cells marked in both.
 *
 * Time Complexity:  O(m * n) - every cell is visited at most twice
 * Space Complexity: O(m * n) - two visited grids plus recursion stack
 */
public class PacificAtlanticWaterFlow {

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return res;
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);        // left edge  -> Pacific
            dfs(heights, atlantic, i, n - 1);   // right edge -> Atlantic
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);        // top edge    -> Pacific
            dfs(heights, atlantic, m - 1, j);   // bottom edge -> Atlantic
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    res.add(cell);
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] h, boolean[][] visited, int r, int c) {
        visited[r][c] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr < 0 || nc < 0 || nr >= h.length || nc >= h[0].length) continue;
            if (visited[nr][nc]) continue;
            if (h[nr][nc] < h[r][c]) continue; // reverse flow: only step to equal/higher
            dfs(h, visited, nr, nc);
        }
    }

    public static void main(String[] args) {
        int[][] heights = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        System.out.println(pacificAtlantic(heights));
        // [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]

        System.out.println(pacificAtlantic(new int[][]{{1}})); // [[0,0]]
    }
}
