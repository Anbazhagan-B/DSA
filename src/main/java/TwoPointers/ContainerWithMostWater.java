package TwoPointers;

/*
 * Problem: Container With Most Water
 * Difficulty: Medium
 * Source: LeetCode #11 (NeetCode 150)
 *
 * You are given an integer array height of length n. There are n vertical lines drawn
 * such that the two endpoints of the i-th line are (i, 0) and (i, height[i]). Find two
 * lines that together with the x-axis form a container, such that the container holds
 * the most water. Return the maximum amount of water it can store.
 *
 * Approach:
 * Two pointers, left = 0 and right = n - 1, sweeping inward. The area between them is
 * min(height[left], height[right]) * (right - left). Always move the pointer at the
 * shorter line inward â moving the taller one cannot increase the area because the
 * width strictly decreases and the height is still capped by the shorter line.
 * Track the running maximum.
 *
 * Time:  O(n) â each pointer moves at most n times.
 * Space: O(1).
 */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int best = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int area = h * (right - left);
            if (area > best) best = area;
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{1, 1}));                      // 1
        System.out.println(maxArea(new int[]{4, 3, 2, 1, 4}));             // 16
        System.out.println(maxArea(new int[]{1, 2, 1}));                   // 2
    }
}
