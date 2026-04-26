package Strings;

/*
 * Problem: Valid Palindrome
 * Difficulty: Easy
 * Source: LeetCode #125 / NeetCode 150
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Approach:
 *   Use two pointers, one from the start and one from the end. Skip non-alphanumeric
 *   characters and compare the lowercase form of the remaining characters. If they
 *   ever differ, the string is not a palindrome.
 *
 * Time Complexity:  O(n) - each character is visited at most once by either pointer.
 * Space Complexity: O(1) - only two index variables are used.
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] inputs = {
                "A man, a plan, a canal: Panama",
                "race a car",
                " ",
                "0P"
        };
        for (String input : inputs) {
            System.out.println("Input : \"" + input + "\"");
            System.out.println("Output: " + isPalindrome(input));
            System.out.println();
        }
    }
}
