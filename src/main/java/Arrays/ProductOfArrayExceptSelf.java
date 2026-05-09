package Arrays;

/*
 * Problem: Product of Array Except Self
 * Difficulty: Medium
 * Source: LeetCode #238 / NeetCode 150
 *
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i]. The product
 * of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 *
 * Approach:
 *  - Do two linear passes. First pass fills answer[i] with the product of all
 *    elements to the LEFT of i (prefix product). Second pass walks right-to-left
 *    multiplying each answer[i] by a running product of elements to its RIGHT.
 *  - This avoids division and keeps everything O(n) time, O(1) extra space
 *    (the output array does not count toward extra space).
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(1) extra (output array excluded)
 */
public class ProductOfArrayExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Prefix products: answer[i] = product of nums[0..i-1]
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Suffix products multiplied in
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        return answer;
    }

    private static String show(int[] a) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i + 1 < a.length) sb.append(", ");
        }
        return sb.append("]").toString();
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {1, 2, 3, 4},
            {-1, 1, 0, -3, 3},
            {2, 3, 4, 5},
            {5, 1, 2}
        };
        for (int[] in : inputs) {
            System.out.println("Input:  " + show(in));
            System.out.println("Output: " + show(productExceptSelf(in)));
            System.out.println();
        }
    }
}
