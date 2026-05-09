package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Problem: Evaluate Reverse Polish Notation
 * Difficulty: Medium
 * Source: LeetCode #150 / NeetCode 150
 *
 * You are given an array of strings tokens that represents an arithmetic
 * expression in Reverse Polish Notation. Evaluate the expression and return
 * an integer representing its value. Valid operators are +, -, *, and /.
 * Each operand may be an integer or another expression. Division between two
 * integers truncates toward zero.
 *
 * Approach:
 *  - Push numeric tokens on a stack. When we see an operator, pop the top two
 *    operands (b then a, since the right operand is on top), apply the
 *    operator, and push the result back. The final stack value is the answer.
 *
 * Time Complexity:  O(n)
 * Space Complexity: O(n)
 */
public class EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            switch (t) {
                case "+": case "-": case "*": case "/":
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(apply(a, b, t));
                    break;
                default:
                    stack.push(Integer.parseInt(t));
            }
        }
        return stack.pop();
    }

    private static int apply(int a, int b, String op) {
        switch (op) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": return a / b; // truncation toward zero matches Java int division
            default: throw new IllegalArgumentException("Unknown op: " + op);
        }
    }

    public static void main(String[] args) {
        String[][] inputs = {
            {"2", "1", "+", "3", "*"},                 // ((2+1)*3) = 9
            {"4", "13", "5", "/", "+"},                // 4 + (13/5) = 6
            {"10","6","9","3","+","-11","*","/","*","17","+","5","+"} // 22
        };
        for (String[] in : inputs) {
            System.out.println("Input:  " + String.join(" ", in));
            System.out.println("Output: " + evalRPN(in));
            System.out.println();
        }
    }
}
