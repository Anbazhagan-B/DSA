package com.DsaProject.DailyChallenge.Arrays;

/*
 * Problem: Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 *
 * You must write an algorithm that runs in O(n) time and WITHOUT using the
 * division operation. The product of any prefix or suffix of nums is
 * guaranteed to fit in a 32-bit integer.
 *
 * Constraints:
 *   - 2 <= nums.length <= 10^5
 *   - -30 <= nums[i] <= 30
 *   - The product of all elements of any prefix or suffix is guaranteed
 *     to fit in a 32-bit integer.
 *
 * Examples:
 *   1) Input:  nums = [1, 2, 3, 4]
 *      Output: [24, 12, 8, 6]
 *      Explanation: answer[0]=2*3*4=24, answer[1]=1*3*4=12,
 *                   answer[2]=1*2*4=8, answer[3]=1*2*3=6.
 *
 *   2) Input:  nums = [-1, 1, 0, -3, 3]
 *      Output: [0, 0, 9, 0, 0]
 *      Explanation: Only the index holding 0 gets a non-zero product (the
 *                   product of the other elements); every other index includes
 *                   the 0 factor, so its product is 0.
 *
 *   3) Input:  nums = [2, 3]
 *      Output: [3, 2]
 *      Explanation: answer[0] is the product of all except nums[0] (=3),
 *                   answer[1] is the product of all except nums[1] (=2).
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        // TODO: implement
        return null;
    }
}
