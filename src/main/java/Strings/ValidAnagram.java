/*
 * Problem: Valid Anagram
 * Difficulty: Easy
 * Source: LeetCode #242 (NeetCode 150 / LeetCode Top Interview 150)
 *
 * Problem Statement:
 *   Given two strings `s` and `t`, return true if `t` is an anagram of `s`,
 *   and false otherwise. An anagram is a word or phrase formed by
 *   rearranging the letters of a different word or phrase, typically using
 *   all the original letters exactly once.
 *
 *   Constraints used here: lowercase English letters only ('a'..'z').
 *
 * Approach:
 *   1. If the two strings differ in length, they cannot be anagrams — return false.
 *   2. Maintain a frequency array of size 26. Walk both strings in lockstep,
 *      incrementing the count for characters in `s` and decrementing for `t`.
 *   3. After the single pass, every count must be zero for the strings to be
 *      anagrams. A final scan of 26 entries is constant-time.
 *
 *   This beats the sort-based O(n log n) approach and uses O(1) extra space
 *   for the fixed 26-letter alphabet.
 *
 * Time Complexity:  O(n)  — single pass over both strings (n = s.length()).
 * Space Complexity: O(1)  — fixed-size 26-int counter, independent of input.
 */

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int c : counts) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Sample 1: classic anagram
        String s1 = "anagram", t1 = "nagaram";
        System.out.println("Input:  s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: " + isAnagram(s1, t1)); // true

        // Sample 2: same letters except one differs
        String s2 = "rat", t2 = "car";
        System.out.println("Input:  s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: " + isAnagram(s2, t2)); // false

        // Sample 3: different lengths
        String s3 = "ab", t3 = "abc";
        System.out.println("Input:  s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("Output: " + isAnagram(s3, t3)); // false

        // Sample 4: empty strings are trivially anagrams
        String s4 = "", t4 = "";
        System.out.println("Input:  s = \"" + s4 + "\", t = \"" + t4 + "\"");
        System.out.println("Output: " + isAnagram(s4, t4)); // true
    }
}
