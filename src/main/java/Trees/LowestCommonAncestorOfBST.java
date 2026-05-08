/**
 * Problem: Lowest Common Ancestor of a Binary Search Tree
 * Difficulty: Medium
 * Source: LeetCode #235 / NeetCode 150 / LeetCode 75
 *
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two nodes p and q.
 * The LCA is the lowest (deepest) node that has both p and q as descendants (a node is also
 * a descendant of itself). Both p and q are guaranteed to exist in the BST.
 *
 * Approach:
 * Exploit BST ordering: if both p and q are less than root, the LCA lies in the left subtree.
 * If both are greater than root, the LCA lies in the right subtree. Otherwise, root is the LCA
 * (one node is on each side, or root equals one of them). Implemented iteratively for O(1) space.
 *
 * Time Complexity: O(h) where h is tree height (O(log n) balanced, O(n) worst-case skewed)
 * Space Complexity: O(1) iterative approach (no recursion stack)
 */

public class LowestCommonAncestorOfBST {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (p.val < current.val && q.val < current.val) {
                current = current.left;           // both nodes in left subtree
            } else if (p.val > current.val && q.val > current.val) {
                current = current.right;          // both nodes in right subtree
            } else {
                return current;                   // split point: current is the LCA
            }
        }
        return null;
    }

    // Helper: insert into BST
    private static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    // Helper: find node by value
    private static TreeNode find(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        return val < root.val ? find(root.left, val) : find(root.right, val);
    }

    public static void main(String[] args) {
        // Build BST: 6,2,8,0,4,7,9,3,5
        TreeNode root = null;
        for (int v : new int[]{6, 2, 8, 0, 4, 7, 9, 3, 5}) {
            root = insert(root, v);
        }

        // LCA(2, 8) = 6 (root splits them)
        System.out.println("LCA(2, 8) = " + lowestCommonAncestor(root, find(root,2), find(root,8)).val); // 6

        // LCA(2, 4) = 2 (2 is ancestor of 4)
        System.out.println("LCA(2, 4) = " + lowestCommonAncestor(root, find(root,2), find(root,4)).val); // 2

        // LCA(3, 5) = 4 (4 splits 3 and 5)
        System.out.println("LCA(3, 5) = " + lowestCommonAncestor(root, find(root,3), find(root,5)).val); // 4

        // LCA(7, 9) = 8 (8 splits 7 and 9)
        System.out.println("LCA(7, 9) = " + lowestCommonAncestor(root, find(root,7), find(root,9)).val); // 8
    }
}
