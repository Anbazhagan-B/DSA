package DP;

import java.util.Arrays;

/*
 * Problem: Longest Increasing Subsequence
 * Difficulty: Medium
 * Source: LeetCode #300 / NeetCode 150
 *
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence. A subsequence is derived from the array by deleting
 * some or no elements without changing the order of the remaining elements.
 *
 * Approach (Patience Sorting / Binary Search, O(n log n)):
 *  - Maintain a "tails" array where tails[i] is the smallest possible tail of
 *    any increasing subsequence of length i+1 seen so far.
 *  - For each num, binary-search for the first tail >= num. If found, replace
 *    it (we found a smaller tail for a same-length subsequence). Otherwise
 *    append num (we extended the longest subsequence). The answer is the
 *    length of tails at the end.
 *  - Note: tails is NOT necessarily a real subsequence of nums; only its
 *    length is correct, which is exactly what the problem asks.
 *
 * Time Complexity:  O(n log n)
 * Space Complexity: O(n)
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int lo = 0, hi = size;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (tails[mid] < x) lo = mid + 1;
                else hi = mid;
            }
            tails[lo] = x;
            if (lo == size) size++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {10, 9, 2, 5, 3, 7, 101, 18},  // expected 4 ([2,3,7,101])
            {0, 1, 0, 3, 2, 3},            // expected 4
            {7, 7, 7, 7, 7, 7, 7},         // expected 1
            {1, 3, 6, 7, 9, 4, 10, 5, 6}   // expected 6
        };
        for (int[] in : inputs) {
            System.out.println("Input:  " + Arrays.toString(in));
            System.out.println("Output: " + lengthOfLIS(in));
            System.out.println();
        }
    }
}
