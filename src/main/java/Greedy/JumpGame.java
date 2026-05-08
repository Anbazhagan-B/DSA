/**
 * Problem: Jump Game
 * Difficulty: Medium
 * Source: LeetCode #55 / NeetCode 150 / LeetCode Top Interview 150
 *
 * You are given an integer array nums where nums[i] represents the maximum jump length
 * from index i. Starting at index 0, return true if you can reach the last index, false otherwise.
 * A jump of length k from index i lands at index i+k (you can jump any length from 0 to nums[i]).
 *
 * Approach:
 * Greedy: track maxReach, the farthest index reachable so far. Iterate left to right;
 * if the current index i exceeds maxReach we are stuck - return false. Otherwise, update
 * maxReach = max(maxReach, i + nums[i]). If maxReach covers the last index, return true.
 *
 * Time Complexity: O(n) - single pass through the array
 * Space Complexity: O(1) - constant extra space
 */

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false;          // stuck, can't advance
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= nums.length - 1) return true;
        }
        return true;
    }

    public static void main(String[] args) {
        // [2,3,1,1,4]: jump 1 step to index 1, then 3 steps to end => true
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4})); // true

        // [3,2,1,0,4]: always land on index 3 (value 0), stuck => false
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4})); // false

        // [0]: already at last index => true
        System.out.println(canJump(new int[]{0}));              // true

        // [2,0,0]: jump 2 from index 0 reaches last index => true
        System.out.println(canJump(new int[]{2, 0, 0}));        // true
    }
}
