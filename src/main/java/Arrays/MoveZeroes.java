/*
 * Problem: Move Zeroes
 * Difficulty: Easy
 * Source: LeetCode #283 (NeetCode 150 - Two Pointers / Arrays)
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements. The operation must be done
 * in-place without making a copy of the array.
 *
 * Approach:
 *   Use a two-pointer technique. Pointer `insertPos` tracks the index where the
 *   next non-zero element should land. Iterate through the array; whenever a
 *   non-zero element is seen, swap it with the slot at `insertPos` and advance
 *   `insertPos`. After the pass, every position before `insertPos` holds the
 *   non-zero elements in original order and the rest are zeros.
 *
 * Time Complexity:  O(n) - single pass through the array.
 * Space Complexity: O(1) - swaps are done in place.
 */
package Arrays;

import java.util.Arrays;

public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[insertPos];
                nums[insertPos] = nums[i];
                nums[i] = tmp;
                insertPos++;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroes solver = new MoveZeroes();

        int[] a = {0, 1, 0, 3, 12};
        solver.moveZeroes(a);
        System.out.println("Input : [0, 1, 0, 3, 12]");
        System.out.println("Output: " + Arrays.toString(a)); // [1, 3, 12, 0, 0]

        int[] b = {0};
        solver.moveZeroes(b);
        System.out.println("Input : [0]");
        System.out.println("Output: " + Arrays.toString(b)); // [0]

        int[] c = {4, 2, 0, 1, 0, 3, 0};
        solver.moveZeroes(c);
        System.out.println("Input : [4, 2, 0, 1, 0, 3, 0]");
        System.out.println("Output: " + Arrays.toString(c)); // [4, 2, 1, 3, 0, 0, 0]
    }
}
