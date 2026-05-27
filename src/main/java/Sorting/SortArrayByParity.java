/**
 * Problem: Sort Array By Parity
 * Difficulty: Easy
 * Source: LeetCode #905 / LeetCode Top Interview 150
 *
 * Problem Statement:
 * Given an integer array nums, move all the even integers to the beginning of the array
 * followed by all the odd integers. Return any array that satisfies this condition
 * (the relative order of even or odd elements does not matter).
 *
 * Approach:
 * Two-pointer in-place swap: maintain a left pointer (scanning for misplaced odd from start)
 * and a right pointer (scanning for misplaced even from end). When nums[left] is odd and
 * nums[right] is even, swap them. Advance both pointers and repeat until they meet.
 * Time Complexity: O(n)
 * Space Complexity: O(1) -- in-place
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 0) left++;
            while (left < right && nums[right] % 2 == 1) right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity solution = new SortArrayByParity();

        // Example 1: [3,1,2,4] -> Expected: evens first e.g. [2,4,1,3]
        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[]{3, 1, 2, 4}))); // [4, 2, 1, 3]

        // Example 2: [0] -> Expected: [0]
        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[]{0}))); // [0]

        // Example 3: [1,3,5,2,4] -> Expected: evens first
        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[]{1, 3, 5, 2, 4}))); // [4, 2, 5, 3, 1]

        // Example 4: [2,1] -> Expected: [2,1]
        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[]{2, 1}))); // [2, 1]
    }
}/**
 * Problem: Sort Array By Parity
 * Difficulty: Easy
 * Source: LeetCode #905 / LeetCode Top Interview 150
 *
 * Problem Statement:
 * Given an integer array nums, move all the even integers to the beginning of the array
 * followed by all the odd integers. Return any array that satisfies this condition
 * (the relative order of even or odd elements does not matter).
 *
 * Approach:
 * Two-pointer in-place swap: maintain a left pointer (scanning for misplaced odd from start)
 * and a right pointer (scanning for misplaced even from end). When nums[left] is odd and
 * nums[right] is even, swap them. Advance both pointers and repeat until they meet.
 * Time Complexity: O(n)
 * Space Complexity: O(1) -- in-place
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 0) left++;
            while (left < right && nums[right] % 2 == 1) right--;
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        SortArrayByParity solution = new SortArrayByParity();

        // Example 1: [3,1,2,4] -> Expected: evens first e.g. [4,2,1,3]
        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[]{3, 1, 2, 4}))); // [4, 2, 1, 3]

        // Example 2: [0] -> Expected: [0]
        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[]{0}))); // [0]

        // Example 3: [1,3,5,2,4] -> Expected: evens first
        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[]{1, 3, 5, 2, 4}))); // [4, 2, 5, 3, 1]

        // Example 4: [2,1] -> Expected: [2,1]
        System.out.println(java.util.Arrays.toString(solution.sortArrayByParity(new int[]{2, 1}))); // [2, 1]
    }
}
