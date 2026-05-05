/*
 * Problem: Longest Common Prefix
 * Difficulty: Easy
 * Source: LeetCode #14 (LeetCode Top Interview 150 - Strings)
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings. If there is no common prefix, return an empty string "".
 *
 * Approach:
 *   Use vertical scanning. Take the first string as the reference and iterate
 *   character by character. For each index, check that every other string has
 *   the same character at that position; if any string is shorter or differs,
 *   return the prefix collected so far. This avoids building an intermediate
 *   prefix and short-circuits as soon as a mismatch is found.
 *
 * Time Complexity:  O(S) where S is the sum of all characters across strings.
 * Space Complexity: O(1) extra (the result string is required output).
 */
package Strings;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        LongestCommonPrefix solver = new LongestCommonPrefix();

        String[] a = {"flower", "flow", "flight"};
        System.out.println("Input : [flower, flow, flight]");
        System.out.println("Output: "" + solver.longestCommonPrefix(a) + """); // "fl"

        String[] b = {"dog", "racecar", "car"};
        System.out.println("Input : [dog, racecar, car]");
        System.out.println("Output: "" + solver.longestCommonPrefix(b) + """); // ""

        String[] c = {"interview", "internet", "internal", "intern"};
        System.out.println("Input : [interview, internet, internal, intern]");
        System.out.println("Output: "" + solver.longestCommonPrefix(c) + """); // "inter"
    }
}
