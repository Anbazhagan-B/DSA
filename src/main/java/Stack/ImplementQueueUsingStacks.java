/*
 * Problem: Implement Queue using Stacks
 * Difficulty: Easy
 * Source: LeetCode #232 (NeetCode 150 - Stack)
 *
 * Implement a first-in-first-out (FIFO) queue using only two stacks. The
 * implemented queue should support all the standard functions of a normal
 * queue (push, pop, peek, empty).
 *
 * Approach:
 *   Maintain two stacks: `in` for new pushes, `out` for serving pop/peek. On
 *   push, simply push to `in`. For pop or peek, if `out` is empty, drain every
 *   element from `in` into `out` (which reverses the order so the oldest
 *   element is on top), then operate on `out`. Each element moves between
 *   stacks at most twice, giving amortized O(1) operations.
 *
 * Time Complexity:  push O(1); pop / peek amortized O(1), worst case O(n).
 * Space Complexity: O(n) for the two stacks combined.
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {

    static class MyQueue {
        private final Deque<Integer> in = new ArrayDeque<>();
        private final Deque<Integer> out = new ArrayDeque<>();

        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            shiftIfNeeded();
            return out.pop();
        }

        public int peek() {
            shiftIfNeeded();
            return out.peek();
        }

        public boolean empty() {
            return in.isEmpty() && out.isEmpty();
        }

        private void shiftIfNeeded() {
            if (out.isEmpty()) {
                while (!in.isEmpty()) {
                    out.push(in.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        System.out.println("peek -> " + q.peek());   // 1
        System.out.println("pop  -> " + q.pop());    // 1
        System.out.println("empty-> " + q.empty()); // false

        q.push(3);
        q.push(4);
        System.out.println("pop  -> " + q.pop());    // 2
        System.out.println("pop  -> " + q.pop());    // 3
        System.out.println("pop  -> " + q.pop());    // 4
        System.out.println("empty-> " + q.empty()); // true
    }
}
