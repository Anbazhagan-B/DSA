/*
 * Problem: Binary Search
 * Difficulty: Easy
 * Source: LeetCode #704 (NeetCode 150)
 *
 * Problem Statement:
 *   Given a sorted-ascending integer array `nums` and a `target`, return the
 *   index of `target` if it exists, otherwise return -1. You must write an
 *   algorithm with O(log n) runtime.
 *
 * Approach:
 *   Classic two-pointer binary search. Keep [lo, hi] inclusive. Compute the
 *   midpoint as `lo + (hi - lo) / 2` (avoids integer overflow on huge
 *   inputs). Compare nums[mid] to target and discard half the search range
 *   each iteration.
 *
 * Time Complexity:  O(log n)  — halves the search range each step.
 * Space Complexity: O(1)      — two indices, done iteratively.
 */

public class BinarySearch {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) lo = mid + 1;
            else                    hi = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = { -1, 0, 3, 5, 9, 12 };
        int t1 = 9;
        System.out.println("Input:  nums = [-1, 0, 3, 5, 9, 12], target = " + t1);
        System.out.println("Output: " + search(nums1, t1)); // 4

        int[] nums2 = { -1, 0, 3, 5, 9, 12 };
        int t2 = 2;
        System.out.println("Input:  nums = [-1, 0, 3, 5, 9, 12], target = " + t2);
        System.out.println("Output: " + search(nums2, t2)); // -1

        int[] nums3 = { 5 };
        System.out.println("Input:  nums = [5], target = 5");
        System.out.println("Output: " + search(nums3, 5)); // 0

        System.out.println("Input:  nums = [], target = 1");
        System.out.println("Output: " + search(new int[0], 1)); // -1
    }
}
