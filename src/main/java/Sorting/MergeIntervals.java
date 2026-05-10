/*
 * Problem: Merge Intervals
 * Difficulty: Medium
 * Source: LeetCode #56 | NeetCode 150 | Striver's SDE Sheet | LeetCode Top Interview 150
 *
 * Problem Statement:
 * Given an array of intervals where intervals[i] = [start_i, end_i], merge all overlapping
 * intervals and return an array of the non-overlapping intervals that cover all the intervals
 * in the input. Two intervals [a,b] and [c,d] overlap when c <= b (i.e., c starts before b ends).
 *
 * Approach:
 * Sort intervals by their start time. Iterate through sorted intervals: if the current interval's
 * start is greater than the last merged interval's end, they don't overlap — add current as a new
 * entry. Otherwise, they overlap — expand the last merged interval's end to the max of both ends.
 *
 * Time Complexity:  O(n log n) — dominated by the sort step
 * Space Complexity: O(n) — output list holds at most n intervals
 */
import java.util.*;

public class MergeIntervals {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort by start
        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval); // no overlap, add as new interval
            } else {
                // overlap: extend end if needed
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        return merged.toArray(new int[0][]);
    }

    private static String fmt(int[][] arr) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            sb.append("[").append(arr[i][0]).append(",").append(arr[i][1]).append("]");
            if (i < arr.length - 1) sb.append(",");
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        // Example 1: [[1,3],[2,6],[8,10],[15,18]] -> [[1,6],[8,10],[15,18]]
        System.out.println("Example 1: " + fmt(merge(new int[][]{{1,3},{2,6},{8,10},{15,18}})));

        // Example 2: [[1,4],[4,5]] -> [[1,5]] (touching intervals merge)
        System.out.println("Example 2: " + fmt(merge(new int[][]{{1,4},{4,5}})));

        // Example 3: [[1,4],[2,3]] -> [[1,4]] (one fully inside other)
        System.out.println("Example 3: " + fmt(merge(new int[][]{{1,4},{2,3}})));

        // Example 4: [[1,2],[3,4],[5,6]] -> [[1,2],[3,4],[5,6]] (no overlaps)
        System.out.println("Example 4: " + fmt(merge(new int[][]{{1,2},{3,4},{5,6}})));
    }
}
