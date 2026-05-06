package SlidingWindow;

/*
 * Problem: Maximum Average Subarray I
 * Difficulty: Easy
 * Source: LeetCode #643 (LeetCode 75)
 *
 * You are given an integer array nums consisting of n elements, and an integer k.
 * Find a contiguous subarray whose length is exactly k that has the maximum average
 * value and return that value. Any answer within 1e-5 of the actual answer is accepted.
 *
 * Approach:
 * Fixed-size sliding window of length k. Compute the sum of the first k elements,
 * then slide the window one step at a time: add the entering element and subtract
 * the leaving element. Track the maximum window sum seen, and return maxSum / k as
 * a double. Avoids re-summing the window each step.
 *
 * Time:  O(n).
 * Space: O(1).
 */
public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        long windowSum = 0;
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        long maxSum = windowSum;
        for (int i = k; i < nums.length; i++) {
            windowSum += nums[i] - nums[i - k];
            if (windowSum > maxSum) {
                maxSum = windowSum;
            }
        }
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4)); // 12.75
        System.out.println(findMaxAverage(new int[]{5}, 1));                     // 5.0
        System.out.println(findMaxAverage(new int[]{0, 4, 0, 3, 2}, 1));         // 4.0
    }
}
