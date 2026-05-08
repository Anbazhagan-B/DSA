/**
 * Problem: Last Stone Weight
 * Difficulty: Easy
 * Source: LeetCode #1046 / NeetCode 150
 *
 * You are given an array of integers stones where stones[i] is the weight of the ith stone.
 * On each turn, choose the two heaviest stones with weights x and y (x <= y) and smash them.
 * If x == y, both are destroyed. If x != y, the stone of weight x is destroyed and y becomes y - x.
 * At the end, at most one stone remains. Return the weight of the last stone, or 0 if none remain.
 *
 * Approach:
 * Use a max-heap (PriorityQueue with reverse order) to always access the two heaviest stones in O(log n).
 * Poll the top two, compute the difference, and re-insert if non-zero. Repeat until <= 1 stone remains.
 *
 * Time Complexity: O(n log n) - n heap operations each O(log n)
 * Space Complexity: O(n) - heap storage
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() > 1) {
            int heaviest = maxHeap.poll();
            int second = maxHeap.poll();
            if (heaviest != second) {
                maxHeap.offer(heaviest - second);
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        // Example 1: smash 8,7->1, smash 4,2->2, smash 2,1->1, smash 1,3->2... => 1
        System.out.println(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})); // 1

        // Example 2: single stone remains as-is
        System.out.println(lastStoneWeight(new int[]{1}));                 // 1

        // Example 3: equal stones cancel each other => 0
        System.out.println(lastStoneWeight(new int[]{2, 2}));              // 0

        // Example 4: 7-3=4, then 4-2=2 => 2
        System.out.println(lastStoneWeight(new int[]{3, 7, 2}));           // 2
    }
}
