/**
 * Problem: Binary Tree Right Side View
 * Difficulty: Medium
 * Source: LeetCode #199 / NeetCode 150
 *
 * Given the root of a binary tree, imagine standing on the right side of it.
 * Return the values of the nodes you can see ordered from top to bottom. A node
 * is visible from the right side if it is the rightmost node at its depth level.
 *
 * Approach:
 * - Perform a level-order (BFS) traversal using a queue.
 * - For each level, process all nodes and record the last (rightmost) node's value.
 * - Add the last node of each level to the result list.
 *
 * Time Complexity:  O(n) - every node is visited exactly once
 * Space Complexity: O(n) - queue holds at most n/2 nodes at the widest level
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == levelSize - 1) result.add(node.val); // rightmost node
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView sol = new BinaryTreeRightSideView();

        // Tree: [1,2,3,null,5,null,4] => right view: [1, 3, 4]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2); root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(5); root1.right.right = new TreeNode(4);
        System.out.println(sol.rightSideView(root1)); // [1, 3, 4]

        // Tree: [1, null, 3] => right view: [1, 3]
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(3);
        System.out.println(sol.rightSideView(root2)); // [1, 3]

        // Empty tree
        System.out.println(sol.rightSideView(null)); // []

        // Tree: [1, 2] => left child only, visible from right: [1, 2]
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        System.out.println(sol.rightSideView(root3)); // [1, 2]
    }
}
