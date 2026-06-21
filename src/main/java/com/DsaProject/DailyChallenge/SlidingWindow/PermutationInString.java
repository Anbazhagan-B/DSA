package com.DsaProject.DailyChallenge.SlidingWindow;

/*
 * Problem: Permutation in String
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise.
 *
 * In other words, return true if one of s1's permutations is a substring of s2.
 * A permutation is a rearrangement of all the characters of a string (using
 * every character exactly once), so you are looking for a contiguous window in
 * s2 whose character counts exactly match the character counts of s1.
 *
 * Constraints:
 *   - 1 <= s1.length, s2.length <= 10^4
 *   - s1 and s2 consist of lowercase English letters only.
 *
 * Examples:
 *   Example 1:
 *     Input:  s1 = "ab", s2 = "eidbaooo"
 *     Output: true
 *     Explanation: s2 contains the substring "ba" (index 3..4), which is a
 *                  permutation of "ab".
 *
 *   Example 2:
 *     Input:  s1 = "ab", s2 = "eidboaoo"
 *     Output: false
 *     Explanation: No contiguous window of length 2 in s2 is a permutation of "ab".
 *
 *   Example 3:
 *     Input:  s1 = "adc", s2 = "dcda"
 *     Output: true
 *     Explanation: The window "dca" (index 1..3) is a permutation of "adc".
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        // TODO: implement
        return false;
    }
}
