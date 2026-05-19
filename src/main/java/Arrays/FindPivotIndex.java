/**
 * Problem: Find Pivot Index
 * Difficulty: Easy
 * Source: LeetCode #724 / LeetCode 75
 *
 * Given an array of integers nums, calculate the pivot index. The pivot index
 * is the index where the sum of all numbers strictly to the left equals the
 * sum of all numbers strictly to the right. Return the leftmost pivot index,
 * or -1 if no such index exists.
 *
 * Approach:
 * - Compute the total sum of the array once.
 * - Iterate through each index maintaining a running leftSum.
 * - At index i, right sum = totalSum - leftSum - nums[i].
 * - If leftSum equals right sum, return i.
 *
 * Time Complexity:  O(n) - two linear passes
 * Space Complexity: O(1) - constant extra space
 */
public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int n : nums) total += n;

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == total - leftSum - nums[i]) return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        FindPivotIndex sol = new FindPivotIndex();

        // pivot at index 3: left=[1,7,3]=11, right=[5,6]=11
        System.out.println(sol.pivotIndex(new int[]{1, 7, 3, 6, 5, 6})); // 3

        // no pivot exists
        System.out.println(sol.pivotIndex(new int[]{1, 2, 3}));           // -1

        // pivot at index 0: left=0, right=-1 ... wait, left=0 right=1+(-1)=0
        System.out.println(sol.pivotIndex(new int[]{2, 1, -1}));          // 0

        // pivot at index 2
        System.out.println(sol.pivotIndex(new int[]{-1, -1, -1, -1, -1, 0})); // 2
    }
}
