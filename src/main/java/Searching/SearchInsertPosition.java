package Searching;

/*
 * Problem: Search Insert Position
 * Difficulty: Easy
 * Source: LeetCode #35 / LeetCode Top Interview 150
 *
 * Given a sorted array of distinct integers and a target value, return the index
 * if the target is found. If not, return the index where it would be inserted to
 * keep the array sorted. The algorithm must run in O(log n) time.
 */

/*
 * Approach:
 * Binary search over the index range [0, n]. Shrink [lo, hi] until they meet; lo
 * lands on the first index whose value is >= target, which is exactly the insert
 * position (and the matching index when the target is present).
 *
 * Time Complexity:  O(log n) - the search range halves each step
 * Space Complexity: O(1)     - only a few index variables
 */
public class SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5)); // 2
        System.out.println(searchInsert(nums, 2)); // 1
        System.out.println(searchInsert(nums, 7)); // 4
        System.out.println(searchInsert(nums, 0)); // 0
    }
}
