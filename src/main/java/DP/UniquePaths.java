/**
 * Problem: Unique Paths
 * Difficulty: Medium
 * Source: LeetCode #62 / NeetCode 150 / Striver's SDE Sheet
 *
 * A robot starts at the top-left corner of an m x n grid. The robot can
 * only move either down or right at any point in time. Find the number
 * of possible unique paths to reach the bottom-right corner.
 *
 * Approach:
 * - Use 1D DP array optimized from the standard 2D DP solution.
 * - dp[j] represents the number of ways to reach column j on the current row.
 * - For every new row, update dp[j] += dp[j-1] (add paths coming from the left).
 * - Initialize all cells to 1 (only one way to traverse the first row/column).
 *
 * Time Complexity:  O(m * n) - fill the dp array for each of m rows
 * Space Complexity: O(n) - only a single row array is maintained
 */
import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // first row: only 1 path to each cell (move right only)

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1]; // paths from above + paths from the left
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        UniquePaths sol = new UniquePaths();

        // 3 rows, 7 cols: 28 unique paths
        System.out.println(sol.uniquePaths(3, 7)); // 28

        // 3 rows, 2 cols: 3 unique paths
        System.out.println(sol.uniquePaths(3, 2)); // 3

        // 1x1 grid: already at destination
        System.out.println(sol.uniquePaths(1, 1)); // 1

        // 7 rows, 3 cols: same as (3,7) by symmetry
        System.out.println(sol.uniquePaths(7, 3)); // 28
    }
}
