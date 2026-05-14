/*
 * Problem: Moving Average from Data Stream
 * Difficulty: Easy
 * Source: LeetCode #346
 *
 * Given a stream of integers and a window size, calculate the moving average of all
 * integers in the sliding window. Implement the MovingAverage class that accepts a
 * size parameter and supports a next(val) method returning the current moving average.
 *
 * Approach:
 * - Use a Queue (LinkedList) to maintain the sliding window of exactly size k elements.
 * - Track a running sum to compute average in O(1) instead of re-summing the window.
 * - When the queue is full, evict the oldest element and subtract it from the running sum.
 * - Divide by queue size (not k) to handle the initial fill phase correctly.
 *
 * Time Complexity:  O(1) per next() call
 * Space Complexity: O(k) for the queue holding at most k elements
 */
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private final int size;
    private final Queue<Integer> queue;
    private double runningSum;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.runningSum = 0.0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            runningSum -= queue.poll();
        }
        queue.offer(val);
        runningSum += val;
        return runningSum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println("next(1)  = " + m.next(1));    // 1.0
        System.out.println("next(10) = " + m.next(10));   // 5.5
        System.out.println("next(3)  = " + m.next(3));    // 4.666...
        System.out.println("next(5)  = " + m.next(5));    // 6.0  (window: 10,3,5)
    }
}/*
 * Problem: Moving Average from Data Stream
 * Difficulty: Easy
 * Source: LeetCode #346
 *
 * Given a stream of integers and a window size, calculate the moving average of all
 * integers in the sliding window. Implement the MovingAverage class that accepts a
 * size parameter and supports a next(val) method returning the current moving average.
 *
 * Approach:
 * - Use a Queue (LinkedList) to maintain the sliding window of exactly size k elements.
 * - Track a running sum to compute average in O(1) instead of re-summing the window.
 * - When the queue is full, evict the oldest element and subtract it from the running sum.
 * - Divide by queue size (not k) to handle the initial fill phase correctly.
 *
 * Time Complexity:  O(1) per next() call
 * Space Complexity: O(k) for the queue holding at most k elements
 */
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    private final int size;
    private final Queue<Integer> queue;
    private double runningSum;

    public MovingAverage(int size) {
        this.size = size;
        this.queue = new LinkedList<>();
        this.runningSum = 0.0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            runningSum -= queue.poll();
        }
        queue.offer(val);
        runningSum += val;
        return runningSum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println("next(1)  = " + m.next(1));
        System.out.println("next(10) = " + m.next(10));
        System.out.println("next(3)  = " + m.next(3));
        System.out.println("next(5)  = " + m.next(5));
    }
}
