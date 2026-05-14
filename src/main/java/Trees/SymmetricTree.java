/**
 * Problem: Symmetric Tree
 * Difficulty: Easy
 * Source: LeetCode #101 | NeetCode 150
 *
 * Problem Statement:
 * Given the root of a binary tree, check whether it is a mirror of itself
 * (i.e., symmetric around its center). A tree is symmetric if the left
 * subtree is a mirror reflection of the right subtree at every level.
 *
 * Approach:
 * Use a recursive helper that checks if two subtrees are mirrors of each other.
 * Two trees are mirrors if their roots are equal and the left child of one is
 * a mirror of the right child of the other, and vice versa.
 *
 * Time Complexity:  O(n) - every node is visited once
 * Space Complexity: O(h) - recursion stack depth (h = tree height, O(n) worst case)
 */
public class SymmetricTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val; this.left = left; this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val
            && isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        SymmetricTree sol = new SymmetricTree();

        // Test 1: [1,2,2,3,4,4,3] -> true
        TreeNode root1 = new TreeNode(1,
            new TreeNode(2, new TreeNode(3), new TreeNode(4)),
            new TreeNode(2, new TreeNode(4), new TreeNode(3)));
        System.out.println("Test 1 (expect true):  " + sol.isSymmetric(root1));

        // Test 2: [1,2,2,null,3,null,3] -> false
        TreeNode root2 = new TreeNode(1,
            new TreeNode(2, null, new TreeNode(3)),
            new TreeNode(2, null, new TreeNode(3)));
        System.out.println("Test 2 (expect false): " + sol.isSymmetric(root2));

        // Test 3: single node -> true
        System.out.println("Test 3 (expect true):  " + sol.isSymmetric(new TreeNode(1)));

        // Test 4: null root -> true
        System.out.println("Test 4 (expect true):  " + sol.isSymmetric(null));
    }
}
