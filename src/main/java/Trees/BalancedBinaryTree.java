/*
 * Problem: Balanced Binary Tree
 * Difficulty: Easy
 * Source: LeetCode #110 | NeetCode 150
 *
 * Problem Statement:
 * Given a binary tree, determine if it is height-balanced. A height-balanced binary tree
 * is one in which the depth of the two subtrees of every node never differs by more than one.
 * Return true if the tree is balanced, false otherwise.
 *
 * Approach:
 * Use a recursive helper that returns the height of each subtree.
 * If at any node the left/right subtree heights differ by more than 1, return -1 as a sentinel
 * for "unbalanced". Propagate -1 upward so the root call returns -1 for an unbalanced tree.
 *
 * Time Complexity:  O(n) — each node is visited exactly once
 * Space Complexity: O(h) — recursion stack where h is the height of the tree
 */
public class BalancedBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Returns height of subtree rooted at node, or -1 if subtree is unbalanced
    private static int checkHeight(TreeNode node) {
        if (node == null) return 0;
        int leftH = checkHeight(node.left);
        if (leftH == -1) return -1;
        int rightH = checkHeight(node.right);
        if (rightH == -1) return -1;
        if (Math.abs(leftH - rightH) > 1) return -1;
        return 1 + Math.max(leftH, rightH);
    }

    public static boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {
        // Example 1: [3,9,20,null,null,15,7] -> true
        TreeNode t1 = new TreeNode(3);
        t1.left = new TreeNode(9);
        t1.right = new TreeNode(20);
        t1.right.left = new TreeNode(15);
        t1.right.right = new TreeNode(7);
        System.out.println("Example 1 [3,9,20,null,null,15,7]: " + isBalanced(t1)); // true

        // Example 2: [1,2,2,3,3,null,null,4,4] -> false
        TreeNode t2 = new TreeNode(1);
        t2.left = new TreeNode(2);
        t2.right = new TreeNode(2);
        t2.left.left = new TreeNode(3);
        t2.left.right = new TreeNode(3);
        t2.left.left.left = new TreeNode(4);
        t2.left.left.right = new TreeNode(4);
        System.out.println("Example 2 unbalanced tree: " + isBalanced(t2)); // false

        // Example 3: empty tree -> true
        System.out.println("Example 3 empty tree: " + isBalanced(null)); // true

        // Example 4: single node -> true
        System.out.println("Example 4 single node: " + isBalanced(new TreeNode(1))); // true
    }
}
