import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/*
 * Problem: Clone Graph
 * Difficulty: Medium
 * Source: LeetCode #133 (NeetCode 150 - Graphs)
 *
 * Problem Statement:
 *   Given a reference of a node in a connected, undirected graph, return a
 *   deep copy (clone) of the graph. Each node contains a value and a list of
 *   its neighbors. The graph may contain cycles, so we need to remember
 *   nodes we have already cloned.
 *
 * Approach:
 *   BFS traversal with a HashMap mapping originals -> clones to handle
 *   cycles. Enqueue the source, create its clone immediately, then for each
 *   dequeued node, create clones of any neighbors not yet seen and link them
 *   into the cloned neighbor list. Each node and edge is processed once.
 *
 * Time Complexity:  O(V + E)
 * Space Complexity: O(V) - visited map + BFS queue
 */
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node(int v) { val = v; neighbors = new ArrayList<>(); }
    }

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        map.put(node, new Node(node.val));
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node nb : cur.neighbors) {
                if (!map.containsKey(nb)) {
                    map.put(nb, new Node(nb.val));
                    queue.offer(nb);
                }
                map.get(cur).neighbors.add(map.get(nb));
            }
        }
        return map.get(node);
    }

    private static String neighborVals(Node n) {
        return n.neighbors.stream().map(x -> String.valueOf(x.val)).collect(Collectors.joining(","));
    }

    public static void main(String[] args) {
        CloneGraph solver = new CloneGraph();

        // Build a 4-node square: 1 - 2 - 3 - 4 - 1
        Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3), n4 = new Node(4);
        n1.neighbors = new ArrayList<>(Arrays.asList(n2, n4));
        n2.neighbors = new ArrayList<>(Arrays.asList(n1, n3));
        n3.neighbors = new ArrayList<>(Arrays.asList(n2, n4));
        n4.neighbors = new ArrayList<>(Arrays.asList(n1, n3));

        Node clone = solver.cloneGraph(n1);
        System.out.println("Clone root val: " + clone.val);
        System.out.println("Different instance from original? " + (clone != n1));
        System.out.println("Clone neighbors of 1: [" + neighborVals(clone) + "]"); // 2,4

        // Single-node graph
        Node solo = new Node(7);
        Node soloClone = solver.cloneGraph(solo);
        System.out.println("Single node clone val=" + soloClone.val + ", neighbors=" + soloClone.neighbors.size());

        // Empty graph
        System.out.println("Null input -> " + solver.cloneGraph(null));
    }
}
