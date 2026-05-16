/*
 * Problem: Longest Palindromic Substring
 * Difficulty: Medium
 * Source: LeetCode #5, NeetCode 150
 *
 * Problem Statement:
 * Given a string s, return the longest palindromic substring in s. A palindrome
 * is a string that reads the same forward and backward. If there are multiple
 * answers, return any one of them.
 *
 * Approach:
 * Expand Around Center — for each index i in the string, treat it as the center
 * and expand outward for both odd-length palindromes (center at i) and even-length
 * palindromes (center between i and i+1). Track the longest expansion found.
 * Update start and end indices whenever a longer palindrome is discovered.
 *
 * Time Complexity: O(n^2) - n centers, each expansion up to O(n)
 * Space Complexity: O(1) - only pointers stored
 */
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddLen  = expand(s, i, i);       // odd-length palindrome
            int evenLen = expand(s, i, i + 1);   // even-length palindrome
            int maxLen  = Math.max(oddLen, evenLen);

            if (maxLen > end - start + 1) {
                start = i - (maxLen - 1) / 2;
                end   = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // length of palindrome
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring sol = new LongestPalindromicSubstring();

        // Example 1: "babad" => "bab" (or "aba", both valid)
        System.out.println(sol.longestPalindrome("babad"));   // Output: bab

        // Example 2: "cbbd" => "bb"
        System.out.println(sol.longestPalindrome("cbbd"));    // Output: bb

        // Example 3: entire string is a palindrome
        System.out.println(sol.longestPalindrome("racecar")); // Output: racecar

        // Example 4: single character
        System.out.println(sol.longestPalindrome("a"));       // Output: a
    }
}
