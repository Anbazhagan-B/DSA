/*
 * Problem: Valid Parentheses
 * Difficulty: Easy
 * Source: LeetCode #20 (NeetCode 150 / LeetCode Top Interview 150)
 *
 * Problem Statement:
 *   Given a string containing only the characters '(', ')', '{', '}', '[' and
 *   ']', determine whether the input string is valid. A string is valid when
 *   open brackets are closed by the same type of brackets, and open brackets
 *   are closed in the correct order.
 *
 * Approach:
 *   Scan the string with a stack of open brackets. On every open bracket,
 *   push it. On every close bracket, pop and compare — if the stack is empty
 *   or the popped open bracket doesn't match, the string is invalid. At the
 *   end the stack must be empty for a valid string.
 *
 * Time Complexity:  O(n)  — one pass over the input.
 * Space Complexity: O(n)  — worst case all characters are open brackets.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    private static final Map<Character, Character> MATCH = Map.of(
        ')', '(',
        ']', '[',
        '}', '{'
    );

    public static boolean isValid(String s) {
        if (s == null) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (MATCH.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != MATCH.get(c)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String[] cases = { "()", "()[]{}", "(]", "([)]", "{[]}", "" };
        boolean[] expected = { true, true, false, false, true, true };
        for (int i = 0; i < cases.length; i++) {
            String s = cases[i];
            boolean got = isValid(s);
            System.out.println("Input:  \"" + s + "\"");
            System.out.println("Output: " + got + "  (expected " + expected[i] + ")");
        }
    }
}
