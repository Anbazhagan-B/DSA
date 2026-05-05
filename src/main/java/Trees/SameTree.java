/*
 * Problem: Same Tree
 * Difficulty: Easy
 * Source: LeetCode #100 (NeetCode 150 - Trees)
 *
 * Problem Statement:
 *   Given the roots of two binary trees p and q, write a function to check if
 *   they are the same or not. Two binary trees are considered the same if
 *   they are structurally identical and the nodes have the same values.
 *
 * Approach:
 *   Recursive DFS. Two trees are equal when both roots are null, or both are
 *   non-null with equal values AND their left and right subtrees are pairwise
 *   equal. Any structural mismatch (one null, one not) immediately fails.
 *
 * Time Complexity:  O(n) - visits every node in the smaller tree once.
 * Space Complexity: O(h) - recursion stack proportional to tree height.
 */
public class SameTree {

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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        SameTree solver = new SameTree();

        // p = [1,2,3], q = [1,2,3]
        TreeNode p1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("p=[1,2,3], q=[1,2,3] -> " + solver.isSameTree(p1, q1)); // true

        // p = [1,2], q = [1,null,2]
        TreeNode p2 = new TreeNode(1, new TreeNode(2), null);
        TreeNode q2 = new TreeNode(1, null, new TreeNode(2));
        System.out.println("p=[1,2], q=[1,null,2] -> " + solver.isSameTree(p2, q2)); // false

        // both empty
        System.out.println("p=[], q=[] -> " + solver.isSameTree(null, null)); // true

        // p = [1,2,1], q = [1,1,2]
        TreeNode p3 = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode q3 = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println("p=[1,2,1], q=[1,1,2] -> " + solver.isSameTree(p3, q3)); // false
    }
}
