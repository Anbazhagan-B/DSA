/*
 * Problem: Climbing Stairs
 * Difficulty: Easy
 * Source: LeetCode #70 | NeetCode 150 (1-D Dynamic Programming)
 *
 * Problem Statement:
 *   You are climbing a staircase. It takes n steps to reach the top. Each
 *   time you can either climb 1 or 2 steps. In how many distinct ways can
 *   you climb to the top?
 *
 * Approach:
 *   Classic Fibonacci-style recurrence: ways(n) = ways(n-1) + ways(n-2),
 *   with base cases ways(1)=1 and ways(2)=2. Iterate bottom-up using two
 *   rolling variables instead of a full array to save space.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */

public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int prev2 = 1, prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println("n=2  -> " + climbStairs(2));  // 2
        System.out.println("n=3  -> " + climbStairs(3));  // 3
        System.out.println("n=5  -> " + climbStairs(5));  // 8
        System.out.println("n=10 -> " + climbStairs(10)); // 89
    }
}
