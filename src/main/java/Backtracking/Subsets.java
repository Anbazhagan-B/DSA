package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem: Subsets
 * Difficulty: Medium
 * Source: LeetCode #78 (NeetCode 150 - Backtracking)
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power
 * set). The solution set must not contain duplicate subsets, and the order of the subsets
 * does not matter.
 *
 * Approach (backtracking / DFS choose-or-skip):
 * Use recursion with an index pointer. At each index, take two paths: include nums[i] in
 * the current subset and recurse, then exclude it (backtrack) and recurse. When the index
 * reaches the array length, record a copy of the current subset. This explores the full
 * 2^n decision tree exactly once.
 *
 * Time Complexity:  O(n * 2^n) - 2^n subsets, each up to length n to copy into the result.
 * Space Complexity: O(n)        - recursion stack and current subset (output excluded).
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(int idx, int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (idx == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Include nums[idx]
        current.add(nums[idx]);
        backtrack(idx + 1, nums, current, result);
        // Exclude nums[idx]
        current.remove(current.size() - 1);
        backtrack(idx + 1, nums, current, result);
    }

    public static void main(String[] args) {
        int[] t1 = {1, 2, 3};
        System.out.println("Input: [1,2,3] -> " + subsets(t1));
        // Expected: 8 subsets including [], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]

        int[] t2 = {0};
        System.out.println("Input: [0]     -> " + subsets(t2));
        // Expected: [[], [0]]

        int[] t3 = {4, 5};
        System.out.println("Input: [4,5]   -> " + subsets(t3));
        // Expected: [[], [4], [5], [4,5]]
    }
}
