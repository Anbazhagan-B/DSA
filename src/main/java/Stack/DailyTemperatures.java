/*
 * Problem: Daily Temperatures
 * Difficulty: Medium
 * Source: LeetCode #739 / NeetCode 150
 *
 * Given an array of daily temperatures, return an array answer such that
 * answer[i] is the number of days you have to wait after the i-th day to get
 * a warmer temperature. If there is no future day with a warmer temperature,
 * answer[i] = 0.
 *
 * Approach:
 *   Monotonic decreasing stack of indices. Iterate left to right. For each
 *   index i, while temperatures[stack.top()] < temperatures[i], pop and record
 *   answer[top] = i - top (we just found a warmer day for that earlier index).
 *   Push i. Indices left on the stack at the end have no warmer future day,
 *   so their answer stays 0.
 *
 * Time:  O(n) — each index is pushed and popped at most once.
 * Space: O(n) for the stack and output.
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // holds indices

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int prev = stack.pop();
                answer[prev] = i - prev;
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] cases = {
                {73, 74, 75, 71, 69, 72, 76, 73}, // -> [1,1,4,2,1,1,0,0]
                {30, 40, 50, 60},                  // -> [1,1,1,0]
                {30, 60, 90},                      // -> [1,1,0]
                {90, 80, 70, 60}                   // -> [0,0,0,0]
        };
        for (int[] c : cases) {
            System.out.println(Arrays.toString(c) + " -> " + Arrays.toString(dailyTemperatures(c)));
        }
    }
}
