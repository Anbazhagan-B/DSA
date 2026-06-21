package com.DsaProject.DailyChallenge.TwoPointers;

import java.util.List;

/*
 * Problem: 3Sum
 *
 * Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k,
 * and nums[i] + nums[j] + nums[k] == 0.
 *
 * The solution set must NOT contain duplicate triplets. The triplets and the
 * overall result may be returned in any order.
 *
 * Approach hint (do not implement yet): sort the array, then for each index i
 * use two pointers (left, right) scanning the remaining subarray inward to find
 * pairs that sum to -nums[i]. Skip equal values to avoid duplicate triplets.
 *
 * Constraints:
 *   - 3 <= nums.length <= 3000
 *   - -10^5 <= nums[i] <= 10^5
 *
 * Examples:
 *
 *   Example 1:
 *     Input:  nums = [-1, 0, 1, 2, -1, -4]
 *     Output: [[-1, -1, 2], [-1, 0, 1]]
 *     Explanation: -1 + -1 + 2 == 0 and -1 + 0 + 1 == 0; the duplicate
 *                  triplet [-1, 0, 1] is only listed once.
 *
 *   Example 2:
 *     Input:  nums = [0, 1, 1]
 *     Output: []
 *     Explanation: The only possible triplet does not sum up to 0.
 *
 *   Example 3:
 *     Input:  nums = [0, 0, 0]
 *     Output: [[0, 0, 0]]
 *     Explanation: The only possible triplet sums up to 0.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        // TODO: implement
        return null;
    }
}
