package com.DsaProject.DailyChallenge.Arrays;

/*
 * Problem: Merge Intervals
 *
 * Given an array of intervals where intervals[i] = [start_i, end_i], merge all
 * overlapping intervals and return an array of the non-overlapping intervals that
 * cover all the intervals in the input.
 *
 * Two intervals [a, b] and [c, d] overlap if they share at least one point, i.e.
 * if c <= b (assuming a <= c after sorting by start). When they overlap, they
 * merge into [a, max(b, d)].
 *
 * Constraints:
 *   - 1 <= intervals.length <= 10^4
 *   - intervals[i].length == 2
 *   - 0 <= start_i <= end_i <= 10^4
 *   - The input intervals are NOT guaranteed to be sorted.
 *
 * Examples:
 *
 *   Example 1:
 *     Input:  [[1,3],[2,6],[8,10],[15,18]]
 *     Output: [[1,6],[8,10],[15,18]]
 *     Explanation: [1,3] and [2,6] overlap (2 <= 3), so they merge into [1,6].
 *                  The rest do not overlap with anything.
 *
 *   Example 2:
 *     Input:  [[1,4],[4,5]]
 *     Output: [[1,5]]
 *     Explanation: [1,4] and [4,5] touch at point 4, which counts as overlapping,
 *                  so they merge into [1,5].
 *
 *   Example 3:
 *     Input:  [[1,4],[0,4]]
 *     Output: [[0,4]]
 *     Explanation: After sorting by start -> [[0,4],[1,4]]; they overlap and merge
 *                  into [0,4].
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        // TODO: implement
        return null;
    }
}
