/**
 * Problem: Count Good Nodes in Binary Tree
 * Difficulty: Medium
 * Source: LeetCode #1448 / NeetCode 150
 *
 * Problem Statement:
 * Given a binary tree root, a node X is called "good" if on the path from root to X
 * there are no nodes with a value greater than X's value. Return the number of good
 * nodes in the binary tree. The root is always a good node.
 *
 * Approach:
 * DFS traversal tracking the maximum value seen on the current root-to-node path.
 * At each node, if node.val >= maxSoFar it is a good node (increment count, update max).
 * Recursively count good nodes in left and right subtrees passing the updated max.
 * Time Complexity: O(n) -- every node is visited exactly once
 * Space Complexity: O(h) -- h is tree height (recursion stack)
 */
public class CountGoodNodesInBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val; this.left = left; this.right = right;
        }
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int count = node.val >= maxSoFar ? 1 : 0;
        int newMax = Math.max(maxSoFar, node.val);

        count += dfs(node.left, newMax);
        count += dfs(node.right, newMax);

        return count;
    }

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();

        // Example 1: [3,1,4,3,null,1,5] -> Expected: 4
        TreeNode root1 = new TreeNode(3,
            new TreeNode(1, new TreeNode(3), null),
            new TreeNode(4, new TreeNode(1), new TreeNode(5))
        );
        System.out.println(solution.goodNodes(root1)); // 4

        // Example 2: [3,3,null,4,2] -> Expected: 3
        TreeNode root2 = new TreeNode(3,
            new TreeNode(3, new TreeNode(4), new TreeNode(2)),
            null
        );
        System.out.println(solution.goodNodes(root2)); // 3

        // Example 3: single node [1] -> Expected: 1
        System.out.println(solution.goodNodes(new TreeNode(1))); // 1

        // Example 4: [2,null,4,10,8] -> Expected: 3
        TreeNode root4 = new TreeNode(2, null,
            new TreeNode(4, new TreeNode(10), new TreeNode(8))
        );
        System.out.println(solution.goodNodes(root4)); // 3
    }
}
