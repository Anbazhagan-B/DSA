/*
 * Problem: Counting Bits
 * Difficulty: Easy
 * Source: LeetCode #338 / NeetCode 150
 *
 * Given a non-negative integer n, return an array ans of length n+1 such that
 * for every i in [0, n], ans[i] is the number of 1-bits in the binary
 * representation of i (a.k.a. popcount).
 *
 * Approach:
 *   Use the recurrence ans[i] = ans[i >> 1] + (i & 1). The popcount of i equals
 *   the popcount of i with its lowest bit dropped, plus that lowest bit. Since
 *   i >> 1 < i, the value we need is already computed — classic O(n) DP.
 *
 * Time:  O(n) — one pass filling the table.
 * Space: O(n) for the output (which is required by the problem).
 */
package BitManipulation;

public class CountingBits {

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] cases = {2, 5, 8, 0};
        for (int n : cases) {
            System.out.println("n=" + n + " -> " + java.util.Arrays.toString(countBits(n)));
        }
        // Expected:
        // n=2 -> [0, 1, 1]
        // n=5 -> [0, 1, 1, 2, 1, 2]
        // n=8 -> [0, 1, 1, 2, 1, 2, 2, 3, 1]
        // n=0 -> [0]
    }
}
