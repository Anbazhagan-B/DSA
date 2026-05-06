/*
 * Problem: House Robber
 * Difficulty: Medium
 * Source: LeetCode #198 / NeetCode 150 / Striver SDE Sheet
 *
 * You are a professional robber planning to rob houses along a street. Each
 * house has a stash of money, but adjacent houses have connected security
 * systems that trigger an alarm if two adjacent houses are robbed on the same
 * night. Given an integer array nums representing the money at each house,
 * return the maximum amount you can rob without alerting the police.
 *
 * Approach:
 * - Classic 1-D DP. At each house i, we make a choice:
 *     rob[i]    = nums[i] + skip[i-1]   (rob house i, so we must have skipped i-1)
 *     skip[i]   = max(rob[i-1], skip[i-1])   (we don't take house i)
 *   The answer is max(rob[n-1], skip[n-1]).
 * - Equivalently, dp[i] = max(dp[i-1], dp[i-2] + nums[i]). We only need the
 *   previous two states, so we collapse the table to two scalars (prev1,
 *   prev2) for O(1) extra space.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
package DP;

public class HouseRobber {

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int prev2 = 0;            // dp[i-2]
        int prev1 = 0;            // dp[i-1]
        for (int v : nums) {
            int curr = Math.max(prev1, prev2 + v);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        // Sample 1: [1,2,3,1] -> 4 (rob house 0 and house 2: 1 + 3)
        System.out.println("rob([1,2,3,1])     = " + rob(new int[]{1, 2, 3, 1}));

        // Sample 2: [2,7,9,3,1] -> 12 (rob 0,2,4: 2 + 9 + 1)
        System.out.println("rob([2,7,9,3,1])   = " + rob(new int[]{2, 7, 9, 3, 1}));

        // Sample 3: [2,1,1,2] -> 4 (rob 0 and 3: 2 + 2)
        System.out.println("rob([2,1,1,2])     = " + rob(new int[]{2, 1, 1, 2}));

        // Sample 4: edge cases
        System.out.println("rob([5])           = " + rob(new int[]{5}));    // 5
        System.out.println("rob([])            = " + rob(new int[]{}));     // 0
    }
}
