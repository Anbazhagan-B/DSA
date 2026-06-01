package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Problem: Baseball Game
 * Difficulty: Easy
 * Source: LeetCode #682
 *
 * You are keeping score for a baseball game with special rules. You are given a
 * list of strings "operations", where each operation is one of:
 *   - an integer x : record a new score of x
 *   - "+"          : record a new score equal to the sum of the previous two
 *   - "D"          : record a new score equal to double the previous score
 *   - "C"          : invalidate and remove the previous score
 * Return the sum of all the scores on the record after applying every operation.
 */

/*
 * Approach:
 * Keep the valid scores on a stack. Numbers push directly, "D" pushes twice the
 * top, "+" pushes the sum of the top two (without losing them), and "C" pops the
 * last score. After processing all tokens, the answer is the sum of the stack.
 *
 * Time Complexity:  O(n) - single pass over the operations
 * Space Complexity: O(n) - stack holding the recorded scores
 */
public class BaseballGame {

    public static int calPoints(String[] ops) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String op : ops) {
            switch (op) {
                case "+": {
                    int top = stack.pop();
                    int sum = top + stack.peek();
                    stack.push(top);
                    stack.push(sum);
                    break;
                }
                case "D":
                    stack.push(2 * stack.peek());
                    break;
                case "C":
                    stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }
        int total = 0;
        for (int score : stack) total += score;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));               // 30
        System.out.println(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})); // 27
        System.out.println(calPoints(new String[]{"1", "C"}));                               // 0
    }
}
