/*
 * Problem: Two Sum
 * Difficulty: Easy
 * Source: LeetCode #1 (NeetCode 150 / LeetCode Top Interview 150)
 *
 * Problem Statement:
 *   Given an array of integers `nums` and an integer `target`, return the
 *   indices of the two numbers such that they add up to `target`.
 *   You may assume that each input would have exactly one solution, and you
 *   may not use the same element twice. You can return the answer in any order.
 *
 * Approach:
 *   Use a HashMap to remember numbers we've already seen and their indices.
 *   For each number `num`, compute `complement = target - num`. If the
 *   complement is already in the map, we've found the pair. Otherwise, store
 *   the current number with its index and move on. This turns an O(n^2)
 *   brute-force search into a single-pass O(n) solution.
 *
 * Time Complexity:  O(n)  — each element is visited at most once.
 * Space Complexity: O(n)  — hashmap may hold up to n entries.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[] { seen.get(complement), i };
            }
            seen.put(nums[i], i);
        }
        // Per problem constraints, a solution is always guaranteed to exist.
        return new int[] {};
    }

    public static void main(String[] args) {
        // Sample 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println("Input:  nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output: " + Arrays.toString(twoSum(nums1, target1))); // [0, 1]

        // Sample 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        System.out.println("Input:  nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output: " + Arrays.toString(twoSum(nums2, target2))); // [1, 2]

        // Sample 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        System.out.println("Input:  nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output: " + Arrays.toString(twoSum(nums3, target3))); // [0, 1]
    }
}
