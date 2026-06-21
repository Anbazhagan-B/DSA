package com.DsaProject.DailyChallenge.TwoPointers;

/*
 * PROBLEM: Container With Most Water
 *
 * You are given an integer array `height` of length n. There are n vertical lines
 * drawn such that the two endpoints of the i-th line are at (i, 0) and (i, height[i]).
 *
 * Find two lines that, together with the x-axis, form a container that holds the
 * most water. Return the maximum amount of water the container can store.
 *
 * The amount of water between lines i and j (i < j) is:
 *     min(height[i], height[j]) * (j - i)
 *
 * Note: you may not slant the container — the water level is bounded by the shorter line.
 *
 * The intended approach uses two pointers starting at both ends of the array and
 * moving inward, always advancing the pointer at the shorter line. This runs in
 * O(n) time and O(1) space — beating the naive O(n^2) check of every pair.
 *
 * CONSTRAINTS:
 *   - n == height.length
 *   - 2 <= n <= 10^5
 *   - 0 <= height[i] <= 10^4
 *
 * EXAMPLES:
 *   1) Input:  height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
 *      Output: 49
 *      Explanation: Lines at index 1 (height 8) and index 8 (height 7) give
 *                   min(8, 7) * (8 - 1) = 7 * 7 = 49, the largest possible area.
 *
 *   2) Input:  height = [1, 1]
 *      Output: 1
 *      Explanation: Only one pair exists: min(1, 1) * (1 - 0) = 1.
 *
 *   3) Input:  height = [4, 3, 2, 1, 4]
 *      Output: 16
 *      Explanation: The first and last lines (both height 4) give
 *                   min(4, 4) * (4 - 0) = 4 * 4 = 16.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        // TODO: implement
        return -1;
    }
}
