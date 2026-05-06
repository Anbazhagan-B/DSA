/*
 * Problem: Number of 1 Bits
 * Difficulty: Easy
 * Source: LeetCode #191 (Bit Manipulation)
 *
 * Statement:
 *   Write a function that takes the binary representation of a positive integer
 *   and returns the number of set bits it has (also known as the Hamming weight).
 *
 * Approach (Brian Kernighan's algorithm):
 *   Each iteration, n & (n - 1) clears the lowest set bit of n. Count how many
 *   times we can do this before n becomes 0. This runs in O(k) where k is the
 *   number of set bits, which is at most 32 for an int and faster than the
 *   naive O(32) shift-and-test loop on sparse inputs.
 *
 * Time Complexity:  O(k) where k = number of set bits (<= 32)
 * Space Complexity: O(1)
 */
package BitManipulation;

public class NumberOfOneBits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfOneBits solver = new NumberOfOneBits();

        int n1 = 11; // binary 1011
        System.out.println("Input: n=11 (1011)");
        System.out.println("Output: " + solver.hammingWeight(n1)); // 3

        int n2 = 128; // binary 10000000
        System.out.println("Input: n=128 (10000000)");
        System.out.println("Output: " + solver.hammingWeight(n2)); // 1

        int n3 = -3; // signed: 11111111111111111111111111111101
        System.out.println("Input: n=-3 (all-ones except bit 1)");
        System.out.println("Output: " + solver.hammingWeight(n3)); // 31
    }
}
