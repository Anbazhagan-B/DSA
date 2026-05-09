package BitManipulation;

/*
 * Problem: Reverse Bits
 * Difficulty: Easy
 * Source: LeetCode #190 / NeetCode 150
 *
 * Reverse bits of a given 32-bit unsigned integer. In Java, we use int (which
 * has no unsigned type) and treat the value as 32 bits. The result should be
 * the bit-reversed representation interpreted as an unsigned integer.
 *
 * Approach:
 *  - Iterate 32 times. On each iteration, shift the result left by 1, OR in the
 *    least-significant bit of n, then unsigned-shift n right by 1.
 *  - After 32 iterations the bits have been mirrored.
 *
 * Time Complexity:  O(1) â fixed 32 iterations
 * Space Complexity: O(1)
 */
public class ReverseBits {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1);
            n >>>= 1; // unsigned right shift
        }
        return result;
    }

    public static void main(String[] args) {
        // Example 1: 00000010100101000001111010011100 -> 00111001011110000010100101000000
        int a = 0b00000010100101000001111010011100;
        System.out.println("Input:  " + Integer.toBinaryString(a));
        System.out.println("Output: " + Integer.toBinaryString(reverseBits(a)));
        System.out.println("Output as unsigned int: " + Integer.toUnsignedString(reverseBits(a)));
        System.out.println();

        // Example 2: 11111111111111111111111111111101 -> 10111111111111111111111111111111
        int b = 0xFFFFFFFD;
        System.out.println("Input:  " + Integer.toBinaryString(b));
        System.out.println("Output: " + Integer.toBinaryString(reverseBits(b)));
        System.out.println("Output as unsigned int: " + Integer.toUnsignedString(reverseBits(b)));
        System.out.println();

        // Example 3: 1 -> 10000000000000000000000000000000
        System.out.println("Input:  " + Integer.toBinaryString(1));
        System.out.println("Output: " + Integer.toBinaryString(reverseBits(1)));
        System.out.println("Output as unsigned int: " + Integer.toUnsignedString(reverseBits(1)));
    }
}
