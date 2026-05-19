/*
 * Problem: Asteroid Collision
 * Difficulty: Medium
 * Source: LeetCode #735 / LeetCode 75
 *
 * Problem Statement:
 * We are given an array of integers representing asteroids in a row. For each
 * asteroid, the absolute value represents its size, and the sign represents its
 * direction (positive = right, negative = left). Asteroids moving in the same
 * direction never meet. When two asteroids collide, the smaller one explodes.
 * If both are the same size, both explode. Return the state of the asteroids
 * after all collisions.
 *
 * Approach:
 * Use a stack to simulate collisions. Push positive asteroids onto the stack.
 * For each negative asteroid, pop and destroy positive asteroids on top that are
 * smaller. If a same-size positive is found, both are destroyed. If no positive
 * remains on top, push the negative asteroid.
 *
 * Time Complexity: O(n) - each asteroid pushed/popped at most once
 * Space Complexity: O(n) - stack storage
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            boolean alive = true;
            while (alive && a < 0 && !stack.isEmpty() && stack.peek() > 0) {
                if (stack.peek() < -a) {
                    stack.pop(); // smaller positive destroyed
                } else if (stack.peek() == -a) {
                    stack.pop(); // equal: both destroyed
                    alive = false;
                } else {
                    alive = false; // negative destroyed by larger positive
                }
            }
            if (alive) stack.push(a);
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        AsteroidCollision sol = new AsteroidCollision();
        // [5,10,-5] => [5,10] (10 survives collision with -5)
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[]{5, 10, -5})));    // [5, 10]
        // [8,-8] => [] (both destroyed)
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[]{8, -8})));        // []
        // [10,2,-5] => [10] (10 survives)
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[]{10, 2, -5})));    // [10]
        // [-2,-1,1,2] => [-2,-1,1,2] (no collisions, moving away from each other)
        System.out.println(Arrays.toString(sol.asteroidCollision(new int[]{-2, -1, 1, 2}))); // [-2, -1, 1, 2]
    }
}
