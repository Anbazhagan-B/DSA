package Arrays;

/*
 * Problem: Maximum Subarray
 * Difficulty: Easy
 * Source: LeetCode #53 / NeetCode 150 / LC Top Interview 150
 *
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum. The array
 * may contain both positive and negative numbers, so a brute-force O(n^2)
 * scan over every (i, j) pair works but is too slow for large inputs.
 *
 * Approach (Kadane's Algorithm):
 *   Walk left-to-right while tracking the best subarray sum ending at the
 *   current index ("currSum"). At each step, either extend the previous
 *   subarray (currSum + nums[i]) or start a fresh one at nums[i] — whichever
 *   is larger. The global answer is the max of currSum across the walk.
 *
 * Time Complexity:  O(n) — single pass through the array.
 * Space Complexity: O(1) — only two scalar variables.
 */
public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Input:  [-2,1,-3,4,-1,2,1,-5,4]");
        System.out.println("Output: " + maxSubArray(a1)); // 6 -> [4,-1,2,1]

        int[] a2 = {1};
        System.out.println("Input:  [1]");
        System.out.println("Output: " + maxSubArray(a2)); // 1

        int[] a3 = {5, 4, -1, 7, 8};
        System.out.println("Input:  [5,4,-1,7,8]");
        System.out.println("Output: " + maxSubArray(a3)); // 23

        int[] a4 = {-3, -2, -1, -4};
        System.out.println("Input:  [-3,-2,-1,-4]");
        System.out.println("Output: " + maxSubArray(a4)); // -1
    }
}
