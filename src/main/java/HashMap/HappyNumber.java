/*
 * Problem: Happy Number
 * Difficulty: Easy
 * Source: LeetCode #202 / NeetCode 150
 *
 * Problem Statement:
 * A happy number is defined by the following process: starting with any positive
 * integer, replace the number by the sum of the squares of its digits, and repeat
 * the process until the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle that does not include 1. Return true if n is a happy number, false otherwise.
 *
 * Approach:
 * Use a HashSet to detect cycles. At each step, compute the sum of squares of digits.
 * If the result equals 1, return true. If we have seen the number before, we are in
 * a cycle and return false.
 *
 * Time Complexity: O(log n) - bounded by cycle length for non-happy numbers
 * Space Complexity: O(log n) - HashSet stores seen numbers
 */

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        while (n != 1) {
            if (seen.contains(n)) return false;
            seen.add(n);
            n = sumOfSquares(n);
        }
        return true;
    }

    private int sumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber sol = new HappyNumber();
        // 19 -> 1^2 + 9^2 = 82 -> 68 -> 100 -> 1 => true
        System.out.println("isHappy(19) = " + sol.isHappy(19));   // true
        // 2 -> 4 -> 16 -> 37 -> 58 -> 89 -> 145 -> 42 -> 20 -> 4 (cycle) => false
        System.out.println("isHappy(2) = " + sol.isHappy(2));     // false
        System.out.println("isHappy(1) = " + sol.isHappy(1));     // true
        System.out.println("isHappy(7) = " + sol.isHappy(7));     // true
    }
}
