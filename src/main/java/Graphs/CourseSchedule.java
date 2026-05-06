/*
 * Problem: Course Schedule
 * Difficulty: Medium
 * Source: LeetCode #207 / NeetCode 150 / Striver SDE Sheet
 *
 * There are numCourses courses labeled from 0 to numCourses - 1. You are given
 * an array prerequisites where prerequisites[i] = [a, b] indicates that you
 * must take course b before course a. Return true if you can finish all
 * courses; otherwise return false.
 *
 * The problem is equivalent to detecting whether a directed graph contains a
 * cycle: edges are b -> a, and a valid course ordering exists iff the graph
 * is a DAG (acyclic).
 *
 * Approach (Kahn's algorithm — BFS topological sort):
 * - Build an adjacency list and an in-degree array from the prerequisites.
 * - Push every course with in-degree 0 into a queue (no prerequisites).
 * - Pop courses one at a time, increment a "finished" counter, and decrement
 *   the in-degree of each neighbor; if a neighbor's in-degree drops to 0 we
 *   enqueue it.
 * - At the end, if finished == numCourses we processed every course, so no
 *   cycle exists and the answer is true. Otherwise some courses are stuck
 *   inside a cycle and the answer is false.
 *
 * Time Complexity: O(V + E)
 * Space Complexity: O(V + E)
 */
package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int course = edge[0];
            int prereq = edge[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int finished = 0;
        while (!queue.isEmpty()) {
            int c = queue.poll();
            finished++;
            for (int next : graph.get(c)) {
                if (--inDegree[next] == 0) queue.offer(next);
            }
        }
        return finished == numCourses;
    }

    public static void main(String[] args) {
        // Sample 1: 2 courses, [1,0] — take 0 then 1 -> true
        System.out.println("canFinish(2, [[1,0]])         = "
                + canFinish(2, new int[][]{{1, 0}}));

        // Sample 2: 2 courses, [[1,0],[0,1]] — cycle -> false
        System.out.println("canFinish(2, [[1,0],[0,1]])   = "
                + canFinish(2, new int[][]{{1, 0}, {0, 1}}));

        // Sample 3: 4 courses with linear chain 0->1->2->3 — true
        System.out.println("canFinish(4, chain)           = "
                + canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));

        // Sample 4: no prerequisites — always true
        System.out.println("canFinish(3, [])              = "
                + canFinish(3, new int[][]{}));
    }
}
