/*
 * Problem: Maximum Depth of Binary Tree
 * Difficulty: Easy
 * Source: LeetCode #104 | NeetCode 150 (Trees)
 *
 * Problem Statement:
 *   Given the root of a binary tree, return its maximum depth.
 *   A binary tree's maximum depth is the number of nodes along the longest
 *   path from the root down to the farthest leaf node.
 *
 * Approach:
 *   Recursive DFS. For any node, depth = 1 + max(depth(left), depth(right)).
 *   Base case: a null node contributes 0. Each node is visited exactly once,
 *   and the call stack holds at most one root-to-leaf path at a time.
 *
 * Time Complexity:  O(n) where n is the number of nodes.
 * Space Complexity: O(h) where h is the height (O(n) worst case, O(log n) balanced).
 */

public class MaximumDepthOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        // Example 1: [3,9,20,null,null,15,7] -> 3
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        System.out.println("Input [3,9,20,null,null,15,7] -> " + maxDepth(t1)); // 3

        // Example 2: [1,null,2] -> 2
        TreeNode t2 = new TreeNode(1);
        t2.right = new TreeNode(2);
        System.out.println("Input [1,null,2] -> " + maxDepth(t2)); // 2

        // Example 3: [] -> 0
        System.out.println("Input [] -> " + maxDepth(null)); // 0
    }
}
