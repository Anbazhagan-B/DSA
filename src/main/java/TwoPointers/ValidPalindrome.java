/*
 * Problem: Valid Palindrome
 * Difficulty: Easy
 * Source: LeetCode #125 | NeetCode 150 (Two Pointers)
 *
 * Problem Statement:
 *   A phrase is a palindrome if, after converting all uppercase letters to
 *   lowercase and removing all non-alphanumeric characters, it reads the
 *   same forward and backward. Given a string s, return true if it is a
 *   palindrome, or false otherwise.
 *
 * Approach:
 *   Two-pointer scan from both ends. Skip characters that are not letters
 *   or digits, then compare lowercase values. Any mismatch returns false;
 *   if the pointers cross without mismatch, the string is a palindrome.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1) (in-place comparison; no extra string built)
 */

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("\"A man, a plan, a canal: Panama\" -> " + isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println("\"race a car\" -> " + isPalindrome("race a car")); // false
        System.out.println("\" \" -> " + isPalindrome(" ")); // true
        System.out.println("\"0P\" -> " + isPalindrome("0P")); // false
    }
}
