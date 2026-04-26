package Trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * Problem: Binary Tree Level Order Traversal
 * Difficulty: Medium
 * Source: LeetCode #102 / NeetCode 150
 *
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values - that is, from left to right, level by level.
 *
 * Approach:
 *   Run a breadth-first search using a queue. At the start of each iteration
 *   capture the current queue size - that is exactly the number of nodes on
 *   the current level. Drain those nodes into one list while enqueueing their
 *   children for the next level.
 *
 * Time Complexity:  O(n) - every node is enqueued and dequeued exactly once.
 * Space Complexity: O(n) - the queue can hold up to one full level (~n/2 nodes).
 */
public class BinaryTreeLevelOrderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    private static TreeNode sample1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        return root;
    }

    private static TreeNode sample2() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        return root;
    }

    public static void main(String[] args) {
        System.out.println("Input : [3,9,20,null,null,15,7]");
        System.out.println("Output: " + levelOrder(sample1()));
        System.out.println();
        System.out.println("Input : [1,2,3,4,null,null,5]");
        System.out.println("Output: " + levelOrder(sample2()));
        System.out.println();
        System.out.println("Input : []");
        System.out.println("Output: " + levelOrder(null));
    }
}
