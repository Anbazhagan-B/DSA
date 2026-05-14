/*
 * Problem: Permutation in String
 * Difficulty: Medium
 * Source: LeetCode #567 (NeetCode 150 / LeetCode Top Interview 150)
 *
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1,
 * or false otherwise. In other words, return true if one of s1's permutations
 * is a substring of s2.
 *
 * Approach:
 * - Use a fixed-size sliding window of length s1.length() over s2.
 * - Maintain two frequency arrays (size 26) for s1 and the current window.
 * - Track a 'matches' counter: how many of the 26 characters have equal frequency.
 * - Slide right: add the incoming char, remove the outgoing char, update matches.
 * - When matches == 26, every character frequency aligns — a permutation exists.
 *
 * Time Complexity:  O(n) where n = s2.length() - single pass with O(26) window ops
 * Space Complexity: O(1) - two fixed-size arrays of length 26
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char c : s1.toCharArray()) count1[c - 'a']++;

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (count1[i] == count2[i]) matches++;
        }

        for (int r = 0; r < s2.length(); r++) {
            // Expand window: add right character
            int c = s2.charAt(r) - 'a';
            if (count2[c] == count1[c]) matches--;
            count2[c]++;
            if (count2[c] == count1[c]) matches++;

            // Shrink window: remove left character once window exceeds s1 length
            if (r >= s1.length()) {
                int l = s2.charAt(r - s1.length()) - 'a';
                if (count2[l] == count1[l]) matches--;
                count2[l]--;
                if (count2[l] == count1[l]) matches++;
            }

            if (matches == 26) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        PermutationInString sol = new PermutationInString();
        System.out.println(sol.checkInclusion("ab", "eidbaooo"));       // true  ("ba" at index 3)
        System.out.println(sol.checkInclusion("ab", "eidboaoo"));       // false
        System.out.println(sol.checkInclusion("adc", "dcda"));          // true  ("cda" is permutation)
        System.out.println(sol.checkInclusion("hello", "ooolleoooleh")); // false
    }
}
