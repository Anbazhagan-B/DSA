/*
 * Problem: Combination Sum
 * Difficulty: Medium
 * Source: LeetCode #39 | NeetCode 150 | Striver's SDE Sheet
 *
 * Problem Statement:
 * Given an array of distinct integers candidates and a target integer target, return a list of
 * all unique combinations of candidates where the chosen numbers sum to target. The same number
 * may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency of at least one chosen number is different. The answer may be returned in any order.
 *
 * Approach:
 * Backtracking: at each step either pick the current candidate again (allowing reuse by keeping
 * the same index) or move to the next candidate. Sort candidates first so we can prune branches
 * where the candidate already exceeds the remaining target. When remaining target reaches 0,
 * record the current combination.
 *
 * Time Complexity:  O(2^(t/m)) where t = target, m = minimum candidate value
 * Space Complexity: O(t/m) — maximum recursion depth (current combination size)
 */
import java.util.*;

public class CombinationSum {

    private static void backtrack(int[] candidates, int target, int start,
                                  List<Integer> current, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) break; // sorted: no further candidates can help
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, current, result); // reuse same i
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        // Example 1: candidates=[2,3,6,7], target=7 -> [[2,2,3],[7]]
        System.out.println("Example 1 (target=7): " + combinationSum(new int[]{2, 3, 6, 7}, 7));

        // Example 2: candidates=[2,3,5], target=8 -> [[2,2,2,2],[2,3,3],[3,5]]
        System.out.println("Example 2 (target=8): " + combinationSum(new int[]{2, 3, 5}, 8));

        // Example 3: candidates=[2], target=1 -> [] (impossible)
        System.out.println("Example 3 (target=1): " + combinationSum(new int[]{2}, 1));

        // Example 4: candidates=[1,2], target=4 -> [[1,1,1,1],[1,1,2],[2,2]]
        System.out.println("Example 4 (target=4): " + combinationSum(new int[]{1, 2}, 4));
    }
}
