package Strings;

/*
 * Problem: Roman to Integer
 * Difficulty: Easy
 * Source: LeetCode #13 (LC Top Interview 150)
 *
 * Roman numerals use the symbols I (1), V (5), X (10), L (50), C (100), D (500), M (1000).
 * Numbers are normally written largest-to-smallest left-to-right, but six subtractive
 * forms exist: IV (4), IX (9), XL (40), XC (90), CD (400), CM (900). Given a Roman
 * numeral string s in the range [1, 3999], return its integer value.
 *
 * Approach:
 * Single left-to-right pass. For each character, look up its base value. If the next
 * character has a strictly larger value (subtractive case), subtract the current value;
 * otherwise add it. This handles all six subtractive forms without enumerating them.
 *
 * Time:  O(n) where n = s.length().
 * Space: O(1) â fixed lookup table of 7 entries.
 */
public class RomanToInteger {

    public static int romanToInt(String s) {
        int[] value = new int[128];
        value['I'] = 1;
        value['V'] = 5;
        value['X'] = 10;
        value['L'] = 50;
        value['C'] = 100;
        value['D'] = 500;
        value['M'] = 1000;

        int total = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int curr = value[s.charAt(i)];
            int next = (i + 1 < n) ? value[s.charAt(i + 1)] : 0;
            if (curr < next) {
                total -= curr;
            } else {
                total += curr;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));      // 3
        System.out.println(romanToInt("LVIII"));    // 58
        System.out.println(romanToInt("MCMXCIV"));  // 1994
        System.out.println(romanToInt("IX"));       // 9
    }
}
