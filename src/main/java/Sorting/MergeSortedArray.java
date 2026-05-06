/*
 * Problem: Merge Sorted Array
 * Difficulty: Easy
 * Source: LeetCode #88 (Sorting / Two Pointers)
 *
 * Statement:
 *   You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 *   order, and two integers m and n representing the number of elements in nums1
 *   and nums2 respectively. Merge nums2 into nums1 as one sorted array. nums1
 *   has length m + n where the last n slots are 0 (placeholders). Modify
 *   nums1 in place; do not return anything.
 *
 * Approach:
 *   Walk three pointers from the right - i over nums1's real elements, j over
 *   nums2, and k over the merged write position at the end of nums1. At each
 *   step write the larger of nums1[i] / nums2[j] into nums1[k]. Filling from
 *   the back avoids overwriting unread nums1 values, so we don't need extra
 *   space. Any remaining nums2 values at the end must still be flushed; nums1
 *   leftovers are already in place.
 *
 * Time Complexity:  O(m + n)
 * Space Complexity: O(1)
 */
package Sorting;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        MergeSortedArray solver = new MergeSortedArray();

        int[] a1 = {1, 2, 3, 0, 0, 0};
        int[] b1 = {2, 5, 6};
        solver.merge(a1, 3, b1, 3);
        System.out.println("Input: nums1=[1,2,3,0,0,0] m=3, nums2=[2,5,6] n=3");
        System.out.println("Output: " + Arrays.toString(a1)); // [1,2,2,3,5,6]

        int[] a2 = {1};
        int[] b2 = {};
        solver.merge(a2, 1, b2, 0);
        System.out.println("Input: nums1=[1] m=1, nums2=[] n=0");
        System.out.println("Output: " + Arrays.toString(a2)); // [1]

        int[] a3 = {0};
        int[] b3 = {1};
        solver.merge(a3, 0, b3, 1);
        System.out.println("Input: nums1=[0] m=0, nums2=[1] n=1");
        System.out.println("Output: " + Arrays.toString(a3)); // [1]
    }
}
