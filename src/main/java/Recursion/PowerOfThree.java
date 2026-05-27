/**
 * Problem: Power of Three
 * Difficulty: Easy
 * Source: LeetCode #326 / NeetCode 150
 *
 * Problem Statement:
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * An integer n is a power of three if there exists an integer x such that n == 3^x.
 * Can you solve it without using any loops/recursion? (Optional follow-up)
 *
 * Approach:
 * Recursive approach: base case n == 1 returns true (3^0 = 1).
 * If n <= 0 or n % 3 != 0, it cannot be a power of three -- return false.
 * Otherwise, divide n by 3 and recurse. Runs in O(log3(n)) time.
 * Time Complexity: O(log3(n))
 * Space Complexity: O(log3(n)) due to call stack
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 3 != 0) return false;
        return isPowerOfThree(n / 3);
    }

    public static void main(String[] args) {
        PowerOfThree solution = new PowerOfThree();

        // Example 1: n=27 -> Expected: true (3^3)
        System.out.println(solution.isPowerOfThree(27)); // true

        // Example 2: n=0 -> Expected: false
        System.out.println(solution.isPowerOfThree(0)); // false

        // Example 3: n=9 -> Expected: true (3^2)
        System.out.println(solution.isPowerOfThree(9)); // true

        // Example 4: n=45 -> Expected: false
        System.out.println(solution.isPowerOfThree(45)); // false
    }
}
