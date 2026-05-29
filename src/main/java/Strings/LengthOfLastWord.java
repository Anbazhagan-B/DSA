package Strings;

/*
 * Problem: Length of Last Word
 * Difficulty: Easy
 * Source: LeetCode #58 (Top Interview 150)
 *
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string. A word is a maximal substring consisting of
 * non-space characters only. The string may contain leading or trailing
 * spaces between words.
 *
 * Approach:
 * Scan from the end of the string. First skip any trailing spaces, then count
 * consecutive non-space characters until a space or the start of the string is
 * reached. That count is the length of the last word. Scanning backwards
 * avoids tracking every word and works in a single pass with no allocation.
 *
 * Time Complexity:  O(n) - at most one backward pass over the characters.
 * Space Complexity: O(1) - constant extra space.
 */
public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        int length = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println("Input: \"Hello World\" -> " + lengthOfLastWord("Hello World")); // 5
        System.out.println("Input: \"   fly me   to   the moon  \" -> "
                + lengthOfLastWord("   fly me   to   the moon  ")); // 4
        System.out.println("Input: \"luffy is still joyboy\" -> "
                + lengthOfLastWord("luffy is still joyboy")); // 6
    }
}
