package Trees;

/*
 * Problem: Diameter of Binary Tree
 * Difficulty: Easy
 * Source: LeetCode #543 / NeetCode 150
 *
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter is the length of the longest path between any two nodes; this path
 * may or may not pass through the root. The length of a path is the number of edges
 * between the two endpoints.
 */

/*
 * Approach:
 * Post-order DFS. For every node compute the heights of its left and right
 * subtrees. The longest path that bends at this node spans (leftHeight +
 * rightHeight) edges; keep a running maximum of that value. The function returns
 * the node's height = 1 + max(leftHeight, rightHeight) to its parent.
 *
 * Time Complexity:  O(n) - each node is visited once
 * Space Complexity: O(h) - recursion stack, h = height of the tree
 */
public class DiameterOfBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        //         1
        //       /   \
        //      2     3
        //     / \
        //    4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        System.out.println(sol.diameterOfBinaryTree(root)); // 3  (4 -> 2 -> 1 -> 3)

        TreeNode single = new TreeNode(1);
        System.out.println(sol.diameterOfBinaryTree(single)); // 0

        TreeNode two = new TreeNode(1);
        two.left = new TreeNode(2);
        System.out.println(sol.diameterOfBinaryTree(two)); // 1
    }
}
