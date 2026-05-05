/*
 * Problem: Min Cost Climbing Stairs
 * Difficulty: Easy
 * Source: LeetCode #746 (NeetCode 150 - 1-D DP)
 *
 * Problem Statement:
 *   You are given an integer array `cost` where cost[i] is the cost of the
 *   ith step on a staircase. Once you pay the cost, you can either climb one
 *   or two steps. You can either start from the step with index 0, or the
 *   step with index 1. Return the minimum cost to reach the top of the floor
 *   (one past the last index).
 *
 * Approach:
 *   Bottom-up dynamic programming. For each step i (from 2 to n), the
 *   minimum cost to reach it is the smaller of (cost to reach i-1 + cost[i-1])
 *   or (cost to reach i-2 + cost[i-2]). Only the two previous values are ever
 *   needed, so we keep them as rolling variables to drop the DP array.
 *
 * Time Complexity:  O(n) - one pass over the cost array.
 * Space Complexity: O(1) - two rolling variables.
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int prev2 = 0; // min cost to reach index i-2
        int prev1 = 0; // min cost to reach index i-1
        for (int i = 2; i <= cost.length; i++) {
            int curr = Math.min(prev1 + cost[i - 1], prev2 + cost[i - 2]);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        MinCostClimbingStairs solver = new MinCostClimbingStairs();

        int[] sample1 = {10, 15, 20};
        System.out.println("Input: [10, 15, 20]");
        System.out.println("Output: " + solver.minCostClimbingStairs(sample1)); // 15

        int[] sample2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println("Input: [1,100,1,1,1,100,1,1,100,1]");
        System.out.println("Output: " + solver.minCostClimbingStairs(sample2)); // 6

        int[] sample3 = {0, 0, 0, 0};
        System.out.println("Input: [0, 0, 0, 0]");
        System.out.println("Output: " + solver.minCostClimbingStairs(sample3)); // 0
    }
}
