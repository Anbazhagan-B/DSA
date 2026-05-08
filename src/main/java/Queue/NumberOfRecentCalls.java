/**
 * Problem: Number of Recent Calls
 * Difficulty: Easy
 * Source: LeetCode #933 / LeetCode 75
 *
 * You have a RecentCounter class which counts the number of recent requests
 * within a certain time frame. Implement the RecentCounter class:
 * - RecentCounter() Initializes the counter with zero recent requests.
 * - int ping(int t) Adds a new request at time t (milliseconds), and returns
 *   the number of requests in the past 3000 milliseconds ([t - 3000, t]).
 * It is guaranteed that every call to ping uses a strictly increasing value of t.
 *
 * Approach:
 * Use a Queue to store all request timestamps. For each ping, add t to the queue,
 * then poll elements from the front that fall outside [t-3000, t].
 * The remaining queue size is the answer - each element is added/removed at most once.
 *
 * Time Complexity: O(1) amortized per ping
 * Space Complexity: O(n) where n is the number of pings in the current 3000ms window
 */

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {

    static class RecentCounter {
        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (queue.peek() < t - 3000) {
                queue.poll();
            }
            return queue.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();

        // ping(1)    -> window [-2999,1], only 1 in queue => 1
        System.out.println("ping(1)    = " + counter.ping(1));    // 1

        // ping(100)  -> window [-2900,100], queue=[1,100] => 2
        System.out.println("ping(100)  = " + counter.ping(100));  // 2

        // ping(3001) -> window [1,3001], queue=[1,100,3001] => 3
        System.out.println("ping(3001) = " + counter.ping(3001)); // 3

        // ping(3002) -> window [2,3002], 1 is evicted, queue=[100,3001,3002] => 3
        System.out.println("ping(3002) = " + counter.ping(3002)); // 3
    }
}
