package com.DsaProject.DailyChallenge.HashMaps;

/*
 * PROBLEM: Subarray Sum Equals K
 *
 * Given an array of integers `nums` and an integer `k`, return the total number
 * of contiguous subarrays whose elements sum to exactly `k`.
 *
 * A subarray is a contiguous, non-empty sequence of elements within the array.
 *
 * The intended approach uses a HashMap of prefix-sum frequencies so the whole
 * thing runs in O(n) time and O(n) space — beating the naive O(n^2) double loop.
 *
 * CONSTRAINTS:
 *   - 1 <= nums.length <= 2 * 10^4
 *   - -1000 <= nums[i] <= 1000   (values may be negative or zero)
 *   - -10^7 <= k <= 10^7
 *   - The answer fits in a 32-bit signed integer.
 *
 * EXAMPLES:
 *   1) Input:  nums = [1, 1, 1], k = 2
 *      Output: 2
 *      Explanation: The subarrays [1,1] (indices 0-1) and [1,1] (indices 1-2) each sum to 2.
 *
 *   2) Input:  nums = [1, 2, 3], k = 3
 *      Output: 2
 *      Explanation: [1,2] (indices 0-1) and [3] (index 2) both sum to 3.
 *
 *   3) Input:  nums = [3, 4, -7, 1, 3, 3, 1, -4], k = 7
 *      Output: 4
 *      Explanation: [3,4], [3,4,-7,1,3,3], [1,3,3], and [3,3,1] each sum to 7.
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        // TODO: implement
        return -1;
    }
}
