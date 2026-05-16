/*
 * Problem: Design Circular Queue
 * Difficulty: Easy
 * Source: LeetCode #622
 *
 * Problem Statement:
 * Design your implementation of the circular queue. The circular queue is a linear
 * data structure where operations are performed based on FIFO principle, and the last
 * position is connected back to the first to form a circle. Implement MyCircularQueue
 * supporting enQueue, deQueue, Front, Rear, isEmpty, and isFull operations.
 *
 * Approach:
 * Use a fixed-size int array with head and tail pointers. On enQueue, write to tail
 * and advance tail using modulo arithmetic. On deQueue, advance head using modulo.
 * Track element count separately to distinguish full vs empty states cleanly.
 *
 * Time Complexity: O(1) for all operations
 * Space Complexity: O(k) where k is the queue capacity
 */
public class DesignCircularQueue {

    private final int[] queue;
    private int head, tail, count, capacity;

    public DesignCircularQueue(int k) {
        capacity = k;
        queue    = new int[k];
        head     = 0;
        tail     = 0;
        count    = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        queue[tail] = value;
        tail        = (tail + 1) % capacity;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        count--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : queue[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }

    public static void main(String[] args) {
        DesignCircularQueue cq = new DesignCircularQueue(3);

        System.out.println(cq.enQueue(1)); // true
        System.out.println(cq.enQueue(2)); // true
        System.out.println(cq.enQueue(3)); // true
        System.out.println(cq.enQueue(4)); // false — full
        System.out.println(cq.Rear());     // 3
        System.out.println(cq.isFull());   // true
        System.out.println(cq.deQueue());  // true
        System.out.println(cq.enQueue(4)); // true
        System.out.println(cq.Rear());     // 4
        System.out.println(cq.Front());    // 2
    }
}
