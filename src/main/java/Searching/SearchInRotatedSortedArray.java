/*
 * Problem: Search in Rotated Sorted Array
 * Difficulty: Medium
 * Source: LeetCode #33 (NeetCode 150 - Binary Search)
 *
 * Problem Statement:
 *   There is an integer array nums sorted in ascending order with distinct
 *   values, possibly rotated at an unknown pivot index. Given the rotated
 *   array and an integer target, return the index of target if it is in
 *   nums, or -1 if it is not. Required runtime: O(log n).
 *
 * Approach:
 *   Modified binary search. At each iteration, exactly one of the two halves
 *   around mid is sorted (the half whose endpoints are in non-decreasing
 *   order). Determine which half is sorted, then check whether the target
 *   lies inside that sorted range. If yes, search that half; otherwise
 *   search the other half. Each step halves the search space.
 *
 * Time Complexity:  O(log n)
 * Space Complexity: O(1)
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                // left half [lo..mid] is sorted
                if (target >= nums[lo] && target < nums[mid]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                // right half [mid..hi] is sorted
                if (target > nums[mid] && target <= nums[hi]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray solver = new SearchInRotatedSortedArray();

        int[] s1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("nums=[4,5,6,7,0,1,2], target=0  -> " + solver.search(s1, 0)); // 4
        System.out.println("nums=[4,5,6,7,0,1,2], target=3  -> " + solver.search(s1, 3)); // -1

        int[] s2 = {1};
        System.out.println("nums=[1], target=0             -> " + solver.search(s2, 0)); // -1
        System.out.println("nums=[1], target=1             -> " + solver.search(s2, 1)); // 0

        int[] s3 = {3, 1};
        System.out.println("nums=[3,1], target=1           -> " + solver.search(s3, 1)); // 1

        int[] s4 = {5, 1, 3};
        System.out.println("nums=[5,1,3], target=3         -> " + solver.search(s4, 3)); // 2
    }
}
