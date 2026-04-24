/*
 * Problem: Sort Colors
 * Difficulty: Medium
 * Source: LeetCode #75 | LeetCode Top Interview 150 (Array / Sorting)
 *
 * Problem Statement:
 *   Given an array nums with n objects colored red (0), white (1), or blue
 *   (2), sort them in-place so that objects of the same color are adjacent
 *   with the order red, white, then blue. You must solve this without the
 *   library's sort function.
 *
 * Approach - Dutch National Flag (one-pass, three pointers):
 *   low  : boundary such that nums[0..low-1] are all 0s.
 *   mid  : current scan index.
 *   high : boundary such that nums[high+1..] are all 2s.
 *   - nums[mid] == 0 -> swap(low, mid); low++; mid++.
 *   - nums[mid] == 1 -> mid++.
 *   - nums[mid] == 2 -> swap(mid, high); high--.  (Do NOT advance mid; the
 *     swapped-in value has not been classified yet.)
 *
 * Time Complexity:  O(n), single pass.
 * Space Complexity: O(1), in-place.
 */

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int t = nums[low]; nums[low] = nums[mid]; nums[mid] = t;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else { // nums[mid] == 2
                int t = nums[mid]; nums[mid] = nums[high]; nums[high] = t;
                high--;
            }
        }
    }

    public static void main(String[] args) {
        int[] a1 = {2, 0, 2, 1, 1, 0};
        sortColors(a1);
        System.out.println("[2,0,2,1,1,0] -> " + Arrays.toString(a1)); // [0,0,1,1,2,2]

        int[] a2 = {2, 0, 1};
        sortColors(a2);
        System.out.println("[2,0,1]       -> " + Arrays.toString(a2)); // [0,1,2]

        int[] a3 = {0};
        sortColors(a3);
        System.out.println("[0]           -> " + Arrays.toString(a3)); // [0]
    }
}
