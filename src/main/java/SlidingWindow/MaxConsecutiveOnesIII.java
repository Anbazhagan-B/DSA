/*
 * Problem: Max Consecutive Ones III
 * Difficulty: Medium
 * Source: LeetCode #1004 / LeetCode 75
 *
 * Problem Statement:
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1s in the array if you can flip at most k 0s.
 *
 * Approach:
 * Use a sliding window with two pointers (left, right). Expand the right pointer
 * and count zeros in the window. When the zero count exceeds k, shrink from the
 * left (decrement zero count if the left element was 0). Track the maximum window
 * size throughout the traversal.
 *
 * Time Complexity: O(n) - each element processed at most twice
 * Space Complexity: O(1) - only pointers and counters used
 */

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0, zeros = 0, maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeros++;
            while (zeros > k) {
                if (nums[left] == 0) zeros--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII sol = new MaxConsecutiveOnesIII();
        // [1,1,1,0,0,0,1,1,1,1,0], k=2 => 6 (flip two 0s in middle)
        System.out.println("longestOnes([1,1,1,0,0,0,1,1,1,1,0], k=2) = "
            + sol.longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2)); // 6
        // [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k=3 => 10
        System.out.println("longestOnes([0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k=3) = "
            + sol.longestOnes(new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3)); // 10
        // [1,1,1], k=0 => 3 (no flips needed)
        System.out.println("longestOnes([1,1,1], k=0) = "
            + sol.longestOnes(new int[]{1,1,1}, 0)); // 3
        // [0,0,0], k=1 => 1
        System.out.println("longestOnes([0,0,0], k=1) = "
            + sol.longestOnes(new int[]{0,0,0}, 1)); // 1
    }
}
