/*
 * Problem: Letter Combinations of a Phone Number
 * Difficulty: Medium
 * Source: LeetCode #17 / NeetCode 150
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent (in any order). The
 * digit-to-letters mapping mirrors the classic phone keypad:
 *   2 -> abc, 3 -> def, 4 -> ghi, 5 -> jkl,
 *   6 -> mno, 7 -> pqrs, 8 -> tuv, 9 -> wxyz.
 * Return [] if the input is empty.
 *
 * Approach:
 *   Standard DFS / backtracking. Maintain a StringBuilder; at depth i pick one
 *   letter from the mapping for digits[i], recurse to depth i+1, then undo.
 *   When depth == digits.length, snapshot the buffer to the result list.
 *
 * Time:  O(n * 4^n) — up to 4 letters per digit, n digits, plus O(n) per leaf
 *        to materialise the string. Tight for the worst case (digits like "777").
 * Space: O(n) recursion depth + O(4^n) output (problem-required).
 */
package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {

    private static final String[] MAP = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
    };

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return result;
        dfs(digits, 0, new StringBuilder(), result);
        return result;
    }

    private static void dfs(String digits, int idx, StringBuilder buf, List<String> out) {
        if (idx == digits.length()) {
            out.add(buf.toString());
            return;
        }
        String letters = MAP[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            buf.append(letters.charAt(i));
            dfs(digits, idx + 1, buf, out);
            buf.deleteCharAt(buf.length() - 1);
        }
    }

    public static void main(String[] args) {
        String[] cases = {"23", "", "2", "7"};
        for (String s : cases) {
            System.out.println("digits=\"" + s + "\" -> " + letterCombinations(s));
        }
        // Expected:
        // "23" -> [ad, ae, af, bd, be, bf, cd, ce, cf]
        // ""   -> []
        // "2"  -> [a, b, c]
        // "7"  -> [p, q, r, s]
    }
}
