package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Problem: Min Stack
 * Difficulty: Medium
 * Source: LeetCode #155 / NeetCode 150 / LC Top Interview 150
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element — all in constant time. Each operation is invoked at most 3 * 10^4
 * times in the LeetCode constraints, so the implementation must avoid any
 * O(n) scan for the minimum.
 *
 * Approach (Auxiliary "min" stack):
 *   Keep a primary stack for the values plus a parallel stack that, at every
 *   level, stores the minimum of all values pushed up to that point. On
 *   push, push min(newVal, currentMin) onto the min-stack. On pop, pop both.
 *   getMin() simply peeks the min-stack — O(1).
 *
 * Time Complexity:  O(1) per push, pop, top, and getMin.
 * Space Complexity: O(n) — two parallel stacks of size n.
 */
public class MinStack {

    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> mins  = new ArrayDeque<>();

    public void push(int val) {
        stack.push(val);
        mins.push(mins.isEmpty() ? val : Math.min(val, mins.peek()));
    }

    public void pop() {
        stack.pop();
        mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }

    public static void main(String[] args) {
        MinStack ms = new MinStack();
        ms.push(-2);
        ms.push(0);
        ms.push(-3);
        System.out.println("After push(-2), push(0), push(-3):");
        System.out.println("  getMin() -> " + ms.getMin()); // -3
        ms.pop();
        System.out.println("After pop():");
        System.out.println("  top()    -> " + ms.top());    // 0
        System.out.println("  getMin() -> " + ms.getMin()); // -2

        MinStack ms2 = new MinStack();
        ms2.push(5);
        ms2.push(5);
        ms2.push(3);
        ms2.push(7);
        System.out.println("After push(5,5,3,7):");
        System.out.println("  getMin() -> " + ms2.getMin()); // 3
        ms2.pop();
        ms2.pop();
        System.out.println("After pop(), pop():");
        System.out.println("  getMin() -> " + ms2.getMin()); // 5
    }
}
