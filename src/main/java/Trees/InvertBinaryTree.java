/*
 * Problem: Invert Binary Tree
 * Difficulty: Easy
 * Source: LeetCode #226 / NeetCode 150
 *
 * Given the root of a binary tree, invert the tree (mirror it across its
 * vertical axis) and return its root. For every node, the left and right
 * subtrees are swapped — recursively applied so the entire tree is mirrored.
 *
 * Approach:
 * - Classic recursive DFS: for each non-null node, recursively invert its left
 *   and right subtrees, then swap the two child pointers. The base case is a
 *   null node, which we just return.
 * - This is a textbook tree-recursion problem. Each node is visited exactly
 *   once and does O(1) work, giving O(n) time.
 * - The recursion stack is bounded by the height of the tree — O(h), which is
 *   O(log n) for a balanced tree and O(n) in the worst case (a degenerate
 *   skewed tree).
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h) — recursion stack, where h is the tree height.
 */
package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // BFS level-order serialization (with nulls) — used only to print results.
    private static List<String> levelOrder(TreeNode root) {
        List<String> out = new ArrayList<>();
        if (root == null) return out;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) { out.add("null"); continue; }
            out.add(String.valueOf(n.val));
            q.offer(n.left);
            q.offer(n.right);
        }
        // Trim trailing nulls for readability.
        int end = out.size();
        while (end > 0 && out.get(end - 1).equals("null")) end--;
        return out.subList(0, end);
    }

    public static void main(String[] args) {
        // Sample 1: [4,2,7,1,3,6,9] -> inverted -> [4,7,2,9,6,3,1]
        TreeNode r1 = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("input  1 = " + levelOrder(r1));
        System.out.println("invert 1 = " + levelOrder(invertTree(r1)));

        // Sample 2: [2,1,3] -> [2,3,1]
        TreeNode r2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("invert 2 = " + levelOrder(invertTree(r2)));

        // Sample 3: empty tree -> empty list
        System.out.println("invert empty = " + levelOrder(invertTree(null)));
    }
}
