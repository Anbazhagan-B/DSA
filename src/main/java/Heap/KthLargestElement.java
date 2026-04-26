package Heap;

import java.util.PriorityQueue;

/*
 * Problem: Kth Largest Element in an Array
 * Difficulty: Medium
 * Source: LeetCode #215 (NeetCode 150 - Heap / Priority Queue)
 *
 * Given an integer array nums and an integer k, return the kth largest element in the
 * array. Note that it is the kth largest element in sorted order, not the kth distinct
 * element. The expected algorithm should be more efficient than full sorting.
 *
 * Approach (min-heap of size k):
 * Maintain a min-heap that holds the top k largest elements seen so far. For each value
 * in nums, push it into the heap; whenever the heap exceeds size k, pop the smallest.
 * After processing every element, the heap's root is the kth largest. Heap operations
 * cost O(log k), and we do n of them, giving O(n log k) overall.
 *
 * Time Complexity:  O(n log k) - n insertions into a heap capped at size k.
 * Space Complexity: O(k)        - the heap itself.
 */
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.offer(n);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] t1 = {3, 2, 1, 5, 6, 4};
        System.out.println("Input: [3,2,1,5,6,4], k=2       -> " + findKthLargest(t1, 2)); // 5

        int[] t2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println("Input: [3,2,3,1,2,4,5,5,6], k=4 -> " + findKthLargest(t2, 4)); // 4

        int[] t3 = {1};
        System.out.println("Input: [1], k=1                 -> " + findKthLargest(t3, 1)); // 1

        int[] t4 = {7, 10, 4, 3, 20, 15};
        System.out.println("Input: [7,10,4,3,20,15], k=3    -> " + findKthLargest(t4, 3)); // 10
    }
}
