package Strings;

import java.util.HashMap;
import java.util.Map;

/*
 * Problem: Longest Palindrome
 * Difficulty: Easy
 * Source: LeetCode #409 / LeetCode 75
 *
 * Given a string s consisting of lowercase or uppercase letters, return the
 * length of the longest palindrome that can be built with those letters. The
 * letters are case sensitive ("Aa" is not a palindrome here). You don't need
 * to construct the palindrome, only return its maximum possible length.
 *
 * Approach:
 *  - Count character frequencies. Every character with an even count
 *    contributes its full count. Each character with an odd count contributes
 *    count-1 to the body, and we may place exactly one odd-count character in
 *    the center, so we add 1 if any odd-count character exists.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(k) where k is the alphabet size
 */
public class LongestPalindrome {

    public static int longestPalindrome(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.merge(c, 1, Integer::sum);
        }
        int length = 0;
        boolean hasOdd = false;
        for (int count : freq.values()) {
            if ((count & 1) == 0) {
                length += count;
            } else {
                length += count - 1;
                hasOdd = true;
            }
        }
        return length + (hasOdd ? 1 : 0);
    }

    public static void main(String[] args) {
        String[] inputs = {
            "abccccdd", // expected 7 -> "dccaccd"
            "a",        // expected 1
            "bb",       // expected 2
            "ccc",      // expected 3
            "Aa"        // expected 1 (case sensitive)
        };
        for (String s : inputs) {
            System.out.println("Input:  \"" + s + "\"");
            System.out.println("Output: " + longestPalindrome(s));
            System.out.println();
        }
    }
}
