/*
 * Problem: Flood Fill
 * Difficulty: Easy
 * Source: LeetCode #733 / NeetCode 150
 *
 * Problem Statement:
 * An image is represented by an m x n integer grid where image[i][j] represents
 * the pixel value of the image. Given a starting pixel (sr, sc) and a new color,
 * perform a flood fill: change the color of the starting pixel and all connected
 * pixels (4-directionally) that have the same original color to the new color.
 *
 * Approach:
 * Use DFS from the starting pixel. If the starting pixel already has the new color,
 * return immediately. Otherwise, recursively visit all 4 neighbors that share the
 * original color and update them to the new color.
 *
 * Time Complexity: O(m * n) - each cell visited at most once
 * Space Complexity: O(m * n) - recursion stack in worst case
 */

import java.util.Arrays;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) return;
        if (image[r][c] != originalColor) return;
        image[r][c] = newColor;
        dfs(image, r + 1, c, originalColor, newColor);
        dfs(image, r - 1, c, originalColor, newColor);
        dfs(image, r, c + 1, originalColor, newColor);
        dfs(image, r, c - 1, originalColor, newColor);
    }

    public static void main(String[] args) {
        FloodFill sol = new FloodFill();

        // Example 1: [[1,1,1],[1,1,0],[1,0,1]], sr=1, sc=1, color=2 => [[2,2,2],[2,2,0],[2,0,1]]
        int[][] img1 = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] res1 = sol.floodFill(img1, 1, 1, 2);
        System.out.println("Example 1:");
        for (int[] row : res1) System.out.println(Arrays.toString(row));

        // Example 2: [[0,0,0],[0,0,0]], sr=0, sc=0, color=0 => [[0,0,0],[0,0,0]]
        int[][] img2 = {{0,0,0},{0,0,0}};
        int[][] res2 = sol.floodFill(img2, 0, 0, 0);
        System.out.println("Example 2:");
        for (int[] row : res2) System.out.println(Arrays.toString(row));

        // Example 3: [[1,1,1],[1,1,0],[1,0,1]], sr=0, sc=0, color=3 => [[3,3,3],[3,3,0],[3,0,1]]
        int[][] img3 = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] res3 = sol.floodFill(img3, 0, 0, 3);
        System.out.println("Example 3:");
        for (int[] row : res3) System.out.println(Arrays.toString(row));
    }
}
