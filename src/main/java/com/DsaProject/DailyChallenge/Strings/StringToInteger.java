package com.DsaProject.DailyChallenge.Strings;

/*
 * Problem: String to Integer (atoi)
 *
 * Implement a function that converts a string to a 32-bit signed integer,
 * mimicking the behaviour of the classic C/C++ atoi function.
 *
 * The conversion follows these steps in order:
 *   1) Read and ignore any leading whitespace (' ').
 *   2) Check for an optional sign: a single '+' or '-'. If neither is present,
 *      the result is assumed to be positive.
 *   3) Read in the next characters as long as they are digits ('0'-'9'),
 *      stopping at the first non-digit character (or the end of the string).
 *      The collected digits form the integer's magnitude. If no digits were
 *      read, the result is 0.
 *   4) Apply the sign from step 2.
 *   5) Clamp the result to the 32-bit signed integer range
 *      [-2^31, 2^31 - 1] = [-2147483648, 2147483647]. Values below the range
 *      are clamped to -2147483648; values above are clamped to 2147483647.
 *
 * Return the resulting integer.
 *
 * Constraints:
 *   - 0 <= s.length <= 200
 *   - s consists of English letters (upper/lower case), digits ('0'-'9'),
 *     ' ', '+', '-', and '.'.
 *
 * Examples:
 *   1) Input:  s = "42"
 *      Output: 42
 *      Explanation: No leading whitespace or sign; "42" parses directly.
 *
 *   2) Input:  s = "   -042"
 *      Output: -42
 *      Explanation: Leading spaces are skipped, '-' sets the sign, and the
 *                   leading zeros in "042" are ignored, giving -42.
 *
 *   3) Input:  s = "4193 with words"
 *      Output: 4193
 *      Explanation: Digits are read until the space, so "4193" is parsed and
 *                   the trailing text is ignored.
 */
public class StringToInteger {

    public int myAtoi(String s) {
        // TODO: implement
        return -1;
    }
}
