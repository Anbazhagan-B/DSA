/*
 * Problem: Permutations
 * Difficulty: Medium
 * Source: LeetCode #46 (Backtracking / NeetCode 150)
 *
 * Statement:
 *   Given an array nums of distinct integers, return all the possible
 *   permutations. You can return the answer in any order.
 *
 * Approach (classic backtracking with a "used" mask):
 *   Build the current permutation incrementally. At each level, iterate every
 *   index that has not been used yet, mark it used, append nums[i] to the
 *   current path, and recurse. When the path's length matches nums.length we
 *   add a copy to the result and unwind. Undoing the choice on the way out is
 *   what makes it a backtrack rather than a flood.
 *
 * Time Complexity:  O(n * n!)  -- n! permutations, each O(n) to copy out
 * Space Complexity: O(n) recursion + O(n) used-array (output not counted)
 */
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums, used, path, result);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Permutations solver = new Permutations();

        int[] n1 = {1, 2, 3};
        System.out.println("Input: nums=[1,2,3]");
        System.out.println("Output: " + solver.permute(n1));
        // Expected: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        int[] n2 = {0, 1};
        System.out.println("Input: nums=[0,1]");
        System.out.println("Output: " + solver.permute(n2)); // [[0,1],[1,0]]

        int[] n3 = {7};
        System.out.println("Input: nums=[7]");
        System.out.println("Output: " + solver.permute(n3)); // [[7]]
    }
}
