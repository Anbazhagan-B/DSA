/*
 * Problem: Longest Substring Without Repeating Characters
 * Difficulty: Medium
 * Source: LeetCode #3 | NeetCode 150 (Sliding Window)
 *
 * Problem Statement:
 *   Given a string s, find the length of the longest substring without
 *   repeating characters.
 *
 * Approach:
 *   Expanding window [l, r] backed by a hash set of characters currently
 *   inside. For each r, if s.charAt(r) is already in the set, shrink from
 *   the left (remove s.charAt(l), l++) until it is gone. Then add the new
 *   character and record the best window size seen so far.
 *
 * Time Complexity:  O(n) - each character enters and leaves the window at most once.
 * Space Complexity: O(min(n, |alphabet|))
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int l = 0, best = 0;
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            while (window.contains(c)) {
                window.remove(s.charAt(l));
                l++;
            }
            window.add(c);
            best = Math.max(best, r - l + 1);
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println("\"abcabcbb\" -> " + lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println("\"bbbbb\"    -> " + lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println("\"pwwkew\"   -> " + lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println("\"\"         -> " + lengthOfLongestSubstring(""));         // 0
    }
}
