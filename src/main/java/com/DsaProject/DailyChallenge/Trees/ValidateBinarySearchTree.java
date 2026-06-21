package com.DsaProject.DailyChallenge.Trees;

/*
 * Problem: Validate Binary Search Tree
 *
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 *
 * A valid BST is defined as follows:
 *   - The left subtree of a node contains only nodes with keys strictly LESS
 *     than the node's key.
 *   - The right subtree of a node contains only nodes with keys strictly
 *     GREATER than the node's key.
 *   - Both the left and right subtrees must also be binary search trees.
 *
 * Note: it is NOT enough to check only a node against its direct children.
 * Every node must satisfy the BST property relative to ALL of its ancestors.
 *
 * Constraints:
 *   - The number of nodes in the tree is in the range [1, 10^4].
 *   - -2^31 <= Node.val <= 2^31 - 1  (be careful with Integer overflow when
 *     tracking lower/upper bounds).
 *
 * Examples:
 *
 *   Example 1:
 *     Input:        2
 *                  / \
 *                 1   3
 *     Output: true
 *     Explanation: Left child (1) < root (2) < right child (3). Valid BST.
 *
 *   Example 2:
 *     Input:        5
 *                  / \
 *                 1   4
 *                    / \
 *                  3   6
 *     Output: false
 *     Explanation: Root is 5, but its right subtree contains 3 and 4, which
 *     are less than 5. The node 4 is valid against its parent but violates
 *     the ancestor constraint, so the tree is not a valid BST.
 *
 *   Example 3:
 *     Input:        2
 *                  / \
 *                 2   2
 *     Output: false
 *     Explanation: Duplicates are not allowed; children must be strictly
 *     less / strictly greater than the node's value.
 */
public class ValidateBinarySearchTree {

    // Standard binary tree node definition.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // TODO: implement
        return false;
    }
}
