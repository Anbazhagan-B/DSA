/*
 * Problem: Gas Station
 * Difficulty: Medium
 * Source: LeetCode #134 | NeetCode 150 | Striver's SDE Sheet
 *
 * Problem Statement:
 * There are n gas stations along a circular route. You are given two integer arrays gas and cost
 * where gas[i] is the amount of gas at station i, and cost[i] is the gas cost to travel from
 * station i to the next station. You begin with an empty tank at one of the gas stations. Given
 * that a solution is guaranteed to be unique if it exists, return the starting gas station index
 * if you can travel around the circuit once, or -1 if impossible.
 *
 * Approach:
 * Greedy single pass: maintain a running tank balance and track total surplus. If tank drops
 * below 0 at station i, no starting point from 0..i can complete the circuit, so reset start
 * to i+1 and reset tank to 0. If total surplus >= 0, the last reset position is the answer.
 *
 * Time Complexity:  O(n) — single pass through all stations
 * Space Complexity: O(1) — only a few integer variables
 */
public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSurplus += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1; // cannot reach beyond i from any earlier start
                tank = 0;
            }
        }
        return totalSurplus >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        // Example 1: gas=[1,2,3,4,5], cost=[3,4,5,1,2] -> 3
        System.out.println("Example 1: " + canCompleteCircuit(
            new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2})); // 3

        // Example 2: gas=[2,3,4], cost=[3,4,3] -> -1 (impossible)
        System.out.println("Example 2: " + canCompleteCircuit(
            new int[]{2, 3, 4}, new int[]{3, 4, 3})); // -1

        // Example 3: gas=[5,1,2,3,4], cost=[4,4,1,5,1] -> 4
        System.out.println("Example 3: " + canCompleteCircuit(
            new int[]{5, 1, 2, 3, 4}, new int[]{4, 4, 1, 5, 1})); // 4

        // Example 4: gas=[1,2,3,4,5], cost=[1,2,3,4,5] -> 0 (any start works, choose 0)
        System.out.println("Example 4: " + canCompleteCircuit(
            new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5})); // 0
    }
}
