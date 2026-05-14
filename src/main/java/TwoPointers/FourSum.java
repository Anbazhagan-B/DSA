/*
 * Problem: 4Sum
 * Difficulty: Medium
 * Source: LeetCode #18 (Striver's SDE Sheet / LeetCode Top Interview 150)
 *
 * Given an integer array nums and an integer target, return all unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that a, b, c, d are distinct indices
 * and nums[a] + nums[b] + nums[c] + nums[d] == target. The answer must not contain
 * duplicate quadruplets.
 *
 * Approach:
 * - Sort the array first to enable two-pointer technique and easy duplicate skipping.
 * - Use two nested loops to fix the first two elements (i, j).
 * - For each pair (i, j), apply two pointers (left, right) to find the remaining two.
 * - Skip duplicates at every level (i, j, left, right) to avoid repeated quadruplets.
 * - Use long arithmetic for sum to prevent integer overflow edge cases.
 *
 * Time Complexity:  O(n^3) - two outer loops + two-pointer inner scan
 * Space Complexity: O(1) excluding the output list
 */
import java.util.*;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum sol = new FourSum();
        System.out.println(sol.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        // [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
        System.out.println(sol.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        // [[2,2,2,2]]
        System.out.println(sol.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
        // multiple valid quadruplets
        System.out.println(sol.fourSum(new int[]{1, 1, 1, 1}, 4));
        // [[1,1,1,1]]
    }
}
