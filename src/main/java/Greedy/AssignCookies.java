/*
 * Problem: Assign Cookies
 * Difficulty: Easy
 * Source: LeetCode #455 (Greedy)
 *
 * Statement:
 *   Each child i has a greed factor g[i] - the minimum size of a cookie that will
 *   content them. Each cookie j has a size s[j]. If s[j] >= g[i], we can assign
 *   cookie j to child i and the child becomes content. Each child can receive at
 *   most one cookie. Return the maximum number of content children.
 *
 * Approach:
 *   Sort both arrays. Walk two pointers i over greed g and j over sizes s.
 *   When s[j] >= g[i], the smallest remaining cookie satisfies the lowest
 *   remaining greed - assign it and advance both. Otherwise advance only j.
 *   This is the classic greedy "smallest sufficient cookie wins" choice.
 *
 * Time Complexity:  O(n log n + m log m)  -- sorting dominates
 * Space Complexity: O(1) auxiliary (ignoring the sort's recursion stack)
 */
package Greedy;

import java.util.Arrays;

public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
            }
            j++;
        }
        return i;
    }

    public static void main(String[] args) {
        AssignCookies solver = new AssignCookies();

        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println("Input: g=[1,2,3], s=[1,1]");
        System.out.println("Output: " + solver.findContentChildren(g1, s1)); // 1

        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println("Input: g=[1,2], s=[1,2,3]");
        System.out.println("Output: " + solver.findContentChildren(g2, s2)); // 2

        int[] g3 = {10, 9, 8, 7};
        int[] s3 = {5, 6, 7, 8};
        System.out.println("Input: g=[10,9,8,7], s=[5,6,7,8]");
        System.out.println("Output: " + solver.findContentChildren(g3, s3)); // 2
    }
}
