/*
 * Problem: Power of Two
 * Difficulty: Easy
 * Source: LeetCode #231 (NeetCode 150 / LeetCode Top Interview 150)
 *
 * Given an integer n, return true if it is a power of two. Otherwise, return false.
 * An integer n is a power of two if there exists an integer x such that n == 2^x.
 *
 * Approach:
 * - Use recursion: base case n == 1 returns true, n <= 0 or odd returns false.
 * - Divide n by 2 each recursive call, reducing the problem by half each time.
 * - This mirrors the mathematical definition: n is a power of two if n/2 is also one.
 * - Alternatively, bit trick: n > 0 && (n & (n-1)) == 0, shown in main as verification.
 *
 * Time Complexity:  O(log n) - we divide by 2 at each step
 * Space Complexity: O(log n) - recursion call stack depth
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }

    public static void main(String[] args) {
        PowerOfTwo sol = new PowerOfTwo();
        System.out.println("isPowerOfTwo(1)  = " + sol.isPowerOfTwo(1));
        System.out.println("isPowerOfTwo(16) = " + sol.isPowerOfTwo(16));
        System.out.println("isPowerOfTwo(3)  = " + sol.isPowerOfTwo(3));
        System.out.println("isPowerOfTwo(0)  = " + sol.isPowerOfTwo(0));
    }
}
