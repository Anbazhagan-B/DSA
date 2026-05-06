/*
 * Problem: K Closest Points to Origin
 * Difficulty: Medium
 * Source: LeetCode #973 (Heap / NeetCode 150)
 *
 * Statement:
 *   Given an array of points where points[i] = [xi, yi] on the X-Y plane and an
 *   integer k, return the k closest points to the origin (0, 0). Distance is
 *   Euclidean: sqrt(x^2 + y^2). The answer can be returned in any order; it is
 *   guaranteed to be unique (apart from the order).
 *
 * Approach (max-heap of size k):
 *   Maintain a max-heap keyed on squared distance (x^2 + y^2 - sqrt is
 *   monotonic so we can skip it). Push each point; whenever the heap exceeds k,
 *   pop the worst one. After processing all points, the heap holds the k
 *   closest. This is O(n log k) time and O(k) space - better than fully sorting
 *   for large n with small k. Quickselect would give O(n) average but is more
 *   code; the heap is the standard interview answer.
 *
 * Time Complexity:  O(n log k)
 * Space Complexity: O(k)
 */
package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin solver = new KClosestPointsToOrigin();

        int[][] p1 = {{1, 3}, {-2, 2}};
        System.out.println("Input: points=[[1,3],[-2,2]], k=1");
        System.out.println("Output: " + Arrays.deepToString(solver.kClosest(p1, 1))); // [[-2,2]]

        int[][] p2 = {{3, 3}, {5, -1}, {-2, 4}};
        System.out.println("Input: points=[[3,3],[5,-1],[-2,4]], k=2");
        System.out.println("Output: " + Arrays.deepToString(solver.kClosest(p2, 2))); // [[3,3],[-2,4]] in some order

        int[][] p3 = {{0, 1}, {1, 0}};
        System.out.println("Input: points=[[0,1],[1,0]], k=2");
        System.out.println("Output: " + Arrays.deepToString(solver.kClosest(p3, 2)));
    }
}
