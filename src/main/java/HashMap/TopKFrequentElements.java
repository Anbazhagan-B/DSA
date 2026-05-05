/*
 * Problem: Top K Frequent Elements
 * Difficulty: Medium
 * Source: LeetCode #347 (NeetCode 150 - Heap / HashMap)
 *
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. The answer may be returned in any order. Solutions must be better
 * than O(n log n).
 *
 * Approach:
 *   1) Count frequencies in a HashMap in O(n).
 *   2) Use bucket sort: create n+1 buckets where index i holds every value
 *      that appeared exactly i times. Iterate buckets from high to low and
 *      collect values until k results are gathered. Bucket sort is O(n) and
 *      avoids the heap path's log factor while staying simple.
 *
 * Time Complexity:  O(n) - count + bucket walk.
 * Space Complexity: O(n) - frequency map plus buckets.
 */
package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) freq.merge(n, 1, Integer::sum);

        List<Integer>[] buckets = new List[nums.length + 1];
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int f = e.getValue();
            if (buckets[f] == null) buckets[f] = new ArrayList<>();
            buckets[f].add(e.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = buckets.length - 1; i >= 0 && idx < k; i--) {
            if (buckets[i] == null) continue;
            for (int val : buckets[i]) {
                result[idx++] = val;
                if (idx == k) break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKFrequentElements solver = new TopKFrequentElements();

        int[] a = {1, 1, 1, 2, 2, 3};
        System.out.println("Input : nums=[1,1,1,2,2,3], k=2");
        System.out.println("Output: " + Arrays.toString(solver.topKFrequent(a, 2))); // [1, 2]

        int[] b = {1};
        System.out.println("Input : nums=[1], k=1");
        System.out.println("Output: " + Arrays.toString(solver.topKFrequent(b, 1))); // [1]

        int[] c = {4, 4, 4, 5, 5, 6, 6, 6, 6, 7};
        System.out.println("Input : nums=[4,4,4,5,5,6,6,6,6,7], k=3");
        System.out.println("Output: " + Arrays.toString(solver.topKFrequent(c, 3))); // [6, 4, 5]
    }
}
