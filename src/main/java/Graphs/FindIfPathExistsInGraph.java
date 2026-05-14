/*
 * Problem: Find if Path Exists in Graph
 * Difficulty: Easy
 * Source: LeetCode #1971 (LeetCode 75)
 *
 * There is a bi-directional graph with n vertices labeled 0 to n-1. Given edges[][],
 * a source vertex, and a destination vertex, return true if a valid path from source
 * to destination exists, or false otherwise.
 *
 * Approach:
 * - Build an adjacency list from the edges array (undirected, so add both directions).
 * - Use BFS starting from source, tracking visited nodes to avoid cycles.
 * - Return true as soon as destination is encountered; false if BFS exhausts all reachable nodes.
 *
 * Time Complexity:  O(V + E) where V = number of vertices, E = number of edges
 * Space Complexity: O(V + E) for adjacency list and visited set
 */
import java.util.*;

public class FindIfPathExistsInGraph {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (source == destination) return true;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.getOrDefault(node, Collections.emptyList())) {
                if (neighbor == destination) return true;
                if (visited.add(neighbor)) queue.offer(neighbor);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindIfPathExistsInGraph sol = new FindIfPathExistsInGraph();
        // All vertices connected in a cycle
        System.out.println(sol.validPath(3, new int[][]{{0,1},{1,2},{2,0}}, 0, 2));          // true
        // Two disconnected components
        System.out.println(sol.validPath(6, new int[][]{{0,1},{0,2},{3,5},{5,4},{4,3}}, 0, 5)); // false
        // Single vertex, source == destination
        System.out.println(sol.validPath(1, new int[][]{}, 0, 0));                            // true
        // Linear chain
        System.out.println(sol.validPath(5, new int[][]{{0,1},{1,2},{2,3},{3,4}}, 0, 4));    // true
    }
}
