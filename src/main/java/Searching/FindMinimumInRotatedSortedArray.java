/*
 * Problem: Find Minimum in Rotated Sorted Array
 * Difficulty: Medium
 * Source: LeetCode #153, NeetCode 150
 *
 * Problem Statement:
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * Given the sorted rotated array nums of unique elements, return the minimum element of
 * this array. You must write an algorithm that runs in O(log n) time.
 *
 * Approach:
 * Use modified binary search. At each step, compare nums[mid] with nums[right].
 * If nums[mid] > nums[right], the minimum must be in the right half (left = mid + 1).
 * Otherwise, the minimum is in the left half including mid (right = mid).
 * The loop ends when left == right, which is the index of the minimum element.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinimumInRotatedSortedArray sol = new FindMinimumInRotatedSortedArray();

        System.out.println(sol.findMin(new int[]{3, 4, 5, 1, 2}));       // Output: 1
        System.out.println(sol.findMin(new int[]{4, 5, 6, 7, 0, 1, 2})); // Output: 0
        System.out.println(sol.findMin(new int[]{11, 13, 15, 17}));       // Output: 11
        System.out.println(sol.findMin(new int[]{2, 1}));                 // Output: 1
    }
}
