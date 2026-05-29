package Arrays;

/*
 * Problem: Majority Element
 * Difficulty: Easy
 * Source: LeetCode #169 (NeetCode 150 / Top Interview 150)
 *
 * Given an array nums of size n, return the majority element. The majority
 * element is the element that appears more than floor(n / 2) times. You may
 * assume that the majority element always exists in the array.
 *
 * Approach (Boyer-Moore Voting):
 * Maintain a candidate and a counter. Walk the array: when the counter hits 0,
 * adopt the current value as the candidate. Increment the counter when the
 * current value matches the candidate, otherwise decrement it. Because the
 * majority element occurs more than n/2 times, it cannot be fully cancelled
 * out, so the final candidate is the answer. This needs no extra space.
 *
 * Time Complexity:  O(n) - single pass over the array.
 * Space Complexity: O(1) - only two scalar variables.
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 3};
        System.out.println("Input: [3, 2, 3] -> Majority: " + majorityElement(a)); // 3

        int[] b = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Input: [2, 2, 1, 1, 1, 2, 2] -> Majority: " + majorityElement(b)); // 2

        int[] c = {7};
        System.out.println("Input: [7] -> Majority: " + majorityElement(c)); // 7
    }
}
