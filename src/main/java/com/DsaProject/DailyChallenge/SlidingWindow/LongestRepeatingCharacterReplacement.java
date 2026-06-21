package com.DsaProject.DailyChallenge.SlidingWindow;

/*
 * PROBLEM: Longest Repeating Character Replacement
 *
 * You are given a string s consisting of only uppercase English letters and an
 * integer k. You may choose any character of the string and change it to any
 * other uppercase English letter. You can perform this operation at most k times.
 *
 * Return the length of the longest substring containing the same letter you can
 * obtain after performing the above operations.
 *
 * CONSTRAINTS:
 *   - 1 <= s.length() <= 10^5
 *   - s consists of only uppercase English letters (A-Z).
 *   - 0 <= k <= s.length()
 *
 * EXAMPLES:
 *
 *   Example 1:
 *     Input:  s = "ABAB", k = 2
 *     Output: 4
 *     Explanation: Replace the two 'A's with two 'B's (or vice versa) to get "BBBB".
 *
 *   Example 2:
 *     Input:  s = "AABABBA", k = 1
 *     Output: 4
 *     Explanation: Replace the one 'A' in the middle with 'B' to form "AABBBBA".
 *                  The substring "BBBB" has length 4. (Other valid windows exist.)
 *
 *   Example 3:
 *     Input:  s = "AAAA", k = 0
 *     Output: 4
 *     Explanation: No replacements needed; the whole string is already one letter.
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        // TODO: implement
        return -1;
    }
}
