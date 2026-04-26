package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Problem: 3Sum
 * Difficulty: Medium
 * Source: LeetCode #15 / NeetCode 150
 *
 * Given an integer array nums, return all the unique triplets [a, b, c]
 * such that a + b + c == 0 and the triplet itself is not duplicated in the result.
 *
 * Approach:
 *   Sort the array, then for each index i fix nums[i] as the first element and use
 *   two pointers (left, right) to find pairs that complete the triplet. Skip
 *   duplicates of i, left, and right to keep the result unique. Stop early once
 *   nums[i] becomes positive since no following triplet can sum to zero.
 *
 * Time Complexity:  O(n^2) - sorting is O(n log n) and the outer loop with the
 *                   two-pointer sweep contributes the dominant O(n^2) factor.
 * Space Complexity: O(1) extra - ignoring the output, only constant indices are used.
 */
public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] cases = {
                {-1, 0, 1, 2, -1, -4},
                {0, 1, 1},
                {0, 0, 0},
                {-2, 0, 1, 1, 2}
        };
        for (int[] input : cases) {
            System.out.println("Input : " + Arrays.toString(input));
            System.out.println("Output: " + threeSum(input));
            System.out.println();
        }
    }
}
