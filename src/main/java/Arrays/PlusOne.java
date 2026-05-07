/*
 * Problem: Plus One
 * Difficulty: Easy
 * Source: LeetCode #66 / LeetCode Top Interview 150
 *
 * You are given a large integer represented as an integer array digits, where each
 * digits[i] is the i-th digit of the integer (most significant first). The integer
 * does not contain any leading 0s, except the number 0 itself. Increment the large
 * integer by one and return the resulting array of digits.
 *
 * Approach:
 *   Walk the array from the rightmost digit. If the digit is < 9, add 1 and return.
 *   Otherwise set it to 0 (carry) and keep walking. If we fall off the left edge it
 *   means every digit was a 9 (e.g., 999 -> 1000), so we allocate a new array of
 *   length n+1 with a leading 1 and trailing 0s.
 *
 * Time:  O(n) — each digit is touched at most once.
 * Space: O(1) extra (the all-9s case allocates O(n) for the larger output).
 */
package Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    private static String toStr(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(", ");
            sb.append(a[i]);
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        int[][] cases = {
                {1, 2, 3},        // -> [1,2,4]
                {4, 3, 2, 1},     // -> [4,3,2,2]
                {9},              // -> [1,0]
                {9, 9, 9}         // -> [1,0,0,0]
        };
        for (int[] c : cases) {
            int[] copy = c.clone();
            System.out.println(toStr(c) + " + 1 = " + toStr(plusOne(copy)));
        }
    }
}
