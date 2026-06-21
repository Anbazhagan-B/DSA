package com.DsaProject.DailyChallenge.Graphs;

/*
 * PROBLEM: Course Schedule
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where
 * prerequisites[i] = [a, b] indicates that you MUST take course b first if you
 * want to take course a.
 *
 *   - For example, the pair [0, 1] means that to take course 0 you have to first
 *     take course 1.
 *
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * In graph terms: treat each course as a node and each prerequisite pair as a
 * directed edge. You can finish all courses if and only if the directed graph
 * contains NO cycle (i.e. a valid topological ordering exists).
 *
 * CONSTRAINTS:
 *   - 1 <= numCourses <= 2000
 *   - 0 <= prerequisites.length <= 5000
 *   - prerequisites[i].length == 2
 *   - 0 <= a, b < numCourses
 *   - All the pairs prerequisites[i] are unique.
 *
 * EXAMPLES:
 *
 *   Example 1:
 *     Input:  numCourses = 2, prerequisites = [[1, 0]]
 *     Output: true
 *     Explanation: Take course 0, then course 1. No cycle, so it is finishable.
 *
 *   Example 2:
 *     Input:  numCourses = 2, prerequisites = [[1, 0], [0, 1]]
 *     Output: false
 *     Explanation: 0 needs 1 and 1 needs 0 -> a cycle, so it is impossible.
 *
 *   Example 3:
 *     Input:  numCourses = 4, prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]
 *     Output: true
 *     Explanation: A valid order is 0 -> 1 -> 2 -> 3 (the diamond has no cycle).
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // TODO: implement
        return false;
    }
}
