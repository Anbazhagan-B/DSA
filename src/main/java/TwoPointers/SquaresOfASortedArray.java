import java.util.Arrays;

/*
 * Problem: Squares of a Sorted Array
 * Difficulty: Easy
 * Source: LeetCode #977 (LeetCode 75 - Two Pointers)
 *
 * Problem Statement:
 *   Given an integer array nums sorted in non-decreasing order, return an
 *   array of the squares of each number sorted in non-decreasing order.
 *
 * Approach:
 *   Two pointers from both ends of the input. Because the input is sorted,
 *   the largest square always lives at one of the two ends. Compare the
 *   absolute values, square the bigger one, and write it to the back of the
 *   result. Move that pointer inward and repeat. This avoids an O(n log n)
 *   sort on the squared values.
 *
 * Time Complexity:  O(n) - one pass, each element visited once.
 * Space Complexity: O(n) - output array (O(1) extra beyond the output).
 */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0, right = n - 1, idx = n - 1;
        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];
            if (leftSq > rightSq) {
                result[idx--] = leftSq;
                left++;
            } else {
                result[idx--] = rightSq;
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SquaresOfASortedArray solver = new SquaresOfASortedArray();

        int[] s1 = {-4, -1, 0, 3, 10};
        System.out.println("Input: [-4, -1, 0, 3, 10]");
        System.out.println("Output: " + Arrays.toString(solver.sortedSquares(s1))); // [0, 1, 9, 16, 100]

        int[] s2 = {-7, -3, 2, 3, 11};
        System.out.println("Input: [-7, -3, 2, 3, 11]");
        System.out.println("Output: " + Arrays.toString(solver.sortedSquares(s2))); // [4, 9, 9, 49, 121]

        int[] s3 = {1, 2, 3};
        System.out.println("Input: [1, 2, 3]");
        System.out.println("Output: " + Arrays.toString(solver.sortedSquares(s3))); // [1, 4, 9]

        int[] s4 = {-5, -3, -2, -1};
        System.out.println("Input: [-5, -3, -2, -1]");
        System.out.println("Output: " + Arrays.toString(solver.sortedSquares(s4))); // [1, 4, 9, 25]
    }
}
