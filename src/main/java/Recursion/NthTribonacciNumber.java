/*
 * Problem: N-th Tribonacci Number
 * Difficulty: Easy
 * Source: LeetCode #1137 / LeetCode 75
 *
 * Problem Statement:
 * The Tribonacci sequence Tn is defined as follows:
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 * Given n, return the value of Tn.
 *
 * Approach:
 * Use iterative bottom-up computation with three rolling variables to avoid
 * recursion overhead. Each step computes the next value as the sum of the
 * previous three, achieving O(n) time with O(1) space.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class NthTribonacciNumber {

    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;

        int t0 = 0, t1 = 1, t2 = 1;
        for (int i = 3; i <= n; i++) {
            int t3 = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = t3;
        }
        return t2;
    }

    public static void main(String[] args) {
        NthTribonacciNumber sol = new NthTribonacciNumber();
        // T4 = 0+1+1+2 = 4
        System.out.println("tribonacci(4) = " + sol.tribonacci(4));   // 4
        // T25 = 1389537
        System.out.println("tribonacci(25) = " + sol.tribonacci(25)); // 1389537
        System.out.println("tribonacci(0) = " + sol.tribonacci(0));   // 0
        System.out.println("tribonacci(1) = " + sol.tribonacci(1));   // 1
    }
}
