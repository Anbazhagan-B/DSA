/*
 * Problem: Implement Stack using Queues
 * Difficulty: Easy
 * Source: LeetCode #225 / LeetCode 75
 *
 * Implement a last-in-first-out (LIFO) stack using only two standard queues
 * (FIFO). The stack should support the standard push, pop, top, and empty
 * operations. You may use only standard queue operations: push to back, peek
 * or pop from front, size, and isEmpty.
 *
 * Approach:
 * - We use a single Deque<Integer> as the underlying queue (only enqueue at
 *   tail and dequeue at head are used — no double-ended cheating).
 * - To make push O(n) but pop/top/empty O(1), on every push we:
 *     1. Add the new element at the back.
 *     2. Rotate the queue: dequeue from the front and re-enqueue at the back
 *        size()-1 times. This brings the just-pushed element to the front,
 *        which is the LIFO ordering we want.
 * - After this, the front of the queue is always the most recently pushed
 *   element, so pop/top simply read/remove from the front.
 *
 * Time Complexity: push = O(n), pop = O(1), top = O(1), empty = O(1).
 * Space Complexity: O(n) for the elements held in the queue.
 */
package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackUsingQueues {

    static class MyStack {
        private final Deque<Integer> q = new ArrayDeque<>();

        public MyStack() { }

        public void push(int x) {
            q.addLast(x);
            // Rotate so the new element ends up at the head.
            for (int i = 0; i < q.size() - 1; i++) {
                q.addLast(q.removeFirst());
            }
        }

        public int pop() {
            return q.removeFirst();
        }

        public int top() {
            return q.peekFirst();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    public static void main(String[] args) {
        // Sample 1: push 1,2 -> top=2, pop=2, empty=false
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println("top   = " + s.top());    // 2
        System.out.println("pop   = " + s.pop());    // 2
        System.out.println("empty = " + s.empty());  // false

        // Sample 2: continue with one element left
        System.out.println("pop   = " + s.pop());    // 1
        System.out.println("empty = " + s.empty());  // true

        // Sample 3: LIFO order across a longer sequence
        MyStack t = new MyStack();
        for (int v : new int[]{10, 20, 30, 40}) t.push(v);
        StringBuilder out = new StringBuilder();
        while (!t.empty()) {
            out.append(t.pop());
            if (!t.empty()) out.append(',');
        }
        System.out.println("drain = " + out);        // 40,30,20,10
    }
}
