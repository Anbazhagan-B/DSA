package DP;

/*
 * Problem: Maximum Product Subarray
 * Difficulty: Medium
 * Source: LeetCode #152 (NeetCode 150)
 *
 * Given an integer array nums, find a contiguous non-empty subarray within the
 * array that has the largest product, and return that product. The test cases
 * are generated so that the answer fits in a 32-bit integer.
 *
 * Approach:
 * Because a negative number flips the sign, track BOTH the maximum and minimum
 * products ending at the current index. When the current value is negative the
 * roles of max and min swap, so compute candidates from value, value*prevMax,
 * and value*prevMin, then take the max for curMax and the min for curMin.
 * Keep a global best across the scan. This is Kadane's algorithm adapted for
 * products.
 *
 * Time Complexity:  O(n) - single pass.
 * Space Complexity: O(1) - constant running state.
 */
public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int best = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            int a = curMax * n;
            int b = curMin * n;
            curMax = Math.max(n, Math.max(a, b));
            curMin = Math.min(n, Math.min(a, b));
            best = Math.max(best, curMax);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println("Input: [2,3,-2,4] -> " + maxProduct(new int[]{2, 3, -2, 4})); // 6
        System.out.println("Input: [-2,0,-1] -> " + maxProduct(new int[]{-2, 0, -1})); // 0
        System.out.println("Input: [-2,3,-4] -> " + maxProduct(new int[]{-2, 3, -4})); // 24
    }
}
