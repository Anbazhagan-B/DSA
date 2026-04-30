package Strings;

import java.util.Arrays;

/*
 * Problem: Reverse String
 * Difficulty: Easy
 * Source: LeetCode #344 / LeetCode 75 / LC Top Interview 150
 *
 * Write a function that reverses a string. The input string is given as an
 * array of characters s. You must do this by modifying the input array
 * in-place with O(1) extra memory.
 *
 * Approach (Two Pointers):
 *   Place pointers at the ends of the array and swap, moving them toward each
 *   other until they meet. Each character is touched once, and no auxiliary
 *   buffer is allocated.
 *
 * Time Complexity:  O(n) — every character is swapped exactly once.
 * Space Complexity: O(1) — in-place swap, no extra array allocated.
 */
public class ReverseString {

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        System.out.println("Input:  ['h','e','l','l','o']");
        System.out.println("Output: " + Arrays.toString(s1)); // [o,l,l,e,h]

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.println("Input:  ['H','a','n','n','a','h']");
        System.out.println("Output: " + Arrays.toString(s2)); // [h,a,n,n,a,H]

        char[] s3 = {'A'};
        reverseString(s3);
        System.out.println("Input:  ['A']");
        System.out.println("Output: " + Arrays.toString(s3)); // [A]
    }
}
