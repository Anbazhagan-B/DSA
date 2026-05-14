/**
 * Problem: Kth Largest Element in a Stream
 * Difficulty: Easy
 * Source: LeetCode #703 | NeetCode 150
 *
 * Problem Statement:
 * Design a class to find the kth largest element in a stream of integers.
 * It is the kth largest element in sorted order, not the kth distinct element.
 * Implement KthLargest(int k, int[] nums) to initialize the object, and
 * int add(int val) to append val to the stream and return the kth largest.
 *
 * Approach:
 * Maintain a min-heap of exactly size k. The heap root is always the kth
 * largest element seen so far. On each add(), push the new value and evict
 * the minimum if the heap grows beyond k elements.
 *
 * Time Complexity:  O(log k) per add() call
 * Space Complexity: O(k) for the min-heap
 */
import java.util.PriorityQueue;

public class KthLargestElementInAStream {

    private final int k;
    private final PriorityQueue<Integer> minHeap;

    public KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // k=3, initial stream=[4,5,8,2]
        KthLargestElementInAStream kth = new KthLargestElementInAStream(3, new int[]{4, 5, 8, 2});
        System.out.println("add(3)  -> " + kth.add(3));   // expect 4
        System.out.println("add(5)  -> " + kth.add(5));   // expect 5
        System.out.println("add(10) -> " + kth.add(10));  // expect 5
        System.out.println("add(9)  -> " + kth.add(9));   // expect 8
        System.out.println("add(4)  -> " + kth.add(4));   // expect 8

        System.out.println();
        // k=1, initial stream=[]
        KthLargestElementInAStream kth2 = new KthLargestElementInAStream(1, new int[]{});
        System.out.println("k=1 add(-3) -> " + kth2.add(-3)); // expect -3
        System.out.println("k=1 add(-2) -> " + kth2.add(-2)); // expect -2
        System.out.println("k=1 add(-4) -> " + kth2.add(-4)); // expect -2
    }
}
