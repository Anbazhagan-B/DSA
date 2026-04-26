package BitManipulation;

/*
 * Problem: Single Number
 * Difficulty: Easy
 * Source: LeetCode #136 (NeetCode 150 - Bit Manipulation)
 *
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one. The algorithm must run in O(n) time and use only O(1) extra space.
 *
 * Approach:
 * XOR has two key properties: a ^ a = 0 and a ^ 0 = a, and XOR is commutative.
 * If we XOR every element of the array together, every value that appears twice cancels
 * itself out to 0, leaving only the unique value behind. This gives an O(n) time and
 * O(1) space solution without needing any auxiliary structure like a HashMap.
 *
 * Time Complexity:  O(n) - single pass through the array.
 * Space Complexity: O(1) - only a single accumulator variable.
 */
public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int n : nums) {
            result ^= n;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] t1 = {2, 2, 1};
        System.out.println("Input: [2,2,1]      -> Single: " + singleNumber(t1)); // 1

        int[] t2 = {4, 1, 2, 1, 2};
        System.out.println("Input: [4,1,2,1,2]  -> Single: " + singleNumber(t2)); // 4

        int[] t3 = {1};
        System.out.println("Input: [1]          -> Single: " + singleNumber(t3)); // 1

        int[] t4 = {-1, -1, -2};
        System.out.println("Input: [-1,-1,-2]   -> Single: " + singleNumber(t4)); // -2
    }
}
