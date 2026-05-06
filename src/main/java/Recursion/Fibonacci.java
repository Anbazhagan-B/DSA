/*
 * Problem: Fibonacci Number
 * Difficulty: Easy
 * Source: LeetCode #509 / NeetCode 150
 *
 * The Fibonacci numbers, commonly denoted F(n), form a sequence such that each
 * number is the sum of the two preceding ones, starting from 0 and 1. Formally:
 *   F(0) = 0, F(1) = 1
 *   F(n) = F(n - 1) + F(n - 2), for n > 1
 * Given an integer n (0 <= n <= 30), return F(n).
 *
 * Approach:
 * - The classic recursive definition F(n) = F(n-1) + F(n-2) is correct but
 *   exponential because it recomputes the same subproblems repeatedly.
 * - We instead walk bottom-up from F(0)=0, F(1)=1, keeping only the last two
 *   values in two scalars (prev2, prev1). At each step the new value is
 *   prev1 + prev2 and we shift the window forward.
 * - This is O(n) time, O(1) space, and covers the constraint n <= 30 trivially.
 * - We also expose a memoized recursive variant (fibMemo) to demonstrate the
 *   top-down DP pattern, which is what most candidates are asked to contrast.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) for the iterative version, O(n) for the memoized one.
 */
package Recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    // Iterative bottom-up DP — the production-friendly answer.
    public static int fib(int n) {
        if (n < 2) return n;
        int prev2 = 0;
        int prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    // Top-down memoized recursion — the "recursion + DP" textbook variant.
    public static int fibMemo(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return fibMemoHelper(n, memo);
    }

    private static int fibMemoHelper(int n, Map<Integer, Integer> memo) {
        if (n < 2) return n;
        Integer cached = memo.get(n);
        if (cached != null) return cached;
        int result = fibMemoHelper(n - 1, memo) + fibMemoHelper(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        // Sample 1: n = 2 -> F(2) = F(1) + F(0) = 1
        System.out.println("fib(2)  iter = " + fib(2)  + " | memo = " + fibMemo(2));   // 1

        // Sample 2: n = 3 -> 2
        System.out.println("fib(3)  iter = " + fib(3)  + " | memo = " + fibMemo(3));   // 2

        // Sample 3: n = 4 -> 3
        System.out.println("fib(4)  iter = " + fib(4)  + " | memo = " + fibMemo(4));   // 3

        // Sample 4: n = 10 -> 55, n = 30 -> 832040 (constraint upper bound)
        System.out.println("fib(10) iter = " + fib(10) + " | memo = " + fibMemo(10));  // 55
        System.out.println("fib(30) iter = " + fib(30) + " | memo = " + fibMemo(30));  // 832040
    }
}
