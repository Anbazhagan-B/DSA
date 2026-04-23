/*
 * Problem: Contains Duplicate
 * Difficulty: Easy
 * Source: LeetCode #217 (NeetCode 150)
 *
 * Problem Statement:
 *   Given an integer array `nums`, return true if any value appears at least
 *   twice in the array, and false if every element is distinct.
 *
 * Approach:
 *   Walk the array once, inserting each element into a HashSet. The first
 *   insertion that returns false (i.e. the value was already present) proves
 *   a duplicate. If we finish the loop without collisions, the array is
 *   duplicate-free. Beats the O(n log n) sort-based approach.
 *
 * Time Complexity:  O(n)  — one pass, each add/contains is O(1) expected.
 * Space Complexity: O(n)  — the set can hold up to n distinct elements.
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class ContainsDuplicate {

    public static boolean containsDuplicate(int[] nums) {
        if (nums == null) return false;
        Set<Integer> seen = new HashSet<>();
        for (int n : nums) {
            if (!seen.add(n)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] cases = {
            { 1, 2, 3, 1 },       // true
            { 1, 2, 3, 4 },       // false
            { 1, 1, 1, 3, 3, 4 }, // true
            { }                   // false
        };
        boolean[] expected = { true, false, true, false };
        for (int i = 0; i < cases.length; i++) {
            System.out.println("Input:  " + Arrays.toString(cases[i]));
            System.out.println("Output: " + containsDuplicate(cases[i])
                + "  (expected " + expected[i] + ")");
        }
    }
}
