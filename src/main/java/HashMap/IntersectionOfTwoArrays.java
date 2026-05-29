package HashMap;

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

/*
 * Problem: Intersection of Two Arrays
 * Difficulty: Easy
 * Source: LeetCode #349
 *
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must be unique and the result may
 * be returned in any order.
 *
 * Approach:
 * Put every value of nums1 into a HashSet for O(1) membership tests. Walk
 * nums2; whenever a value is present in that set, add it to a result set
 * (which also guarantees uniqueness) and remove it from the first set so it is
 * not added twice. Finally copy the result set into an int array.
 *
 * Time Complexity:  O(n + m) - each array is scanned once.
 * Space Complexity: O(n) - the set built from nums1 plus the result set.
 */
public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> pool = new HashSet<>();
        for (int n : nums1) {
            pool.add(n);
        }
        Set<Integer> result = new HashSet<>();
        for (int n : nums2) {
            if (pool.contains(n)) {
                result.add(n);
            }
        }
        int[] out = new int[result.size()];
        int i = 0;
        for (int n : result) {
            out[i++] = n;
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println("Input: [1,2,2,1], [2,2] -> "
                + Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}))); // [2]
        System.out.println("Input: [4,9,5], [9,4,9,8,4] -> "
                + Arrays.toString(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}))); // [4, 9]
        System.out.println("Input: [1,2,3], [4,5,6] -> "
                + Arrays.toString(intersection(new int[]{1, 2, 3}, new int[]{4, 5, 6}))); // []
    }
}
