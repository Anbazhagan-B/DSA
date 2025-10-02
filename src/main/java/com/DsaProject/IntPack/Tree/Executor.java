package com.DsaProject.IntPack.Tree;


import java.util.ArrayList;

public class Executor {

    public void execute()
    {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(5);
        root.left.left = new TreeLinkNode(3);
        root.left.right = new TreeLinkNode(4);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        connect(root);
    }

    public ArrayList<Integer> preorder(TreeNode root) {
        //  code here
        ArrayList<Integer> preorderNodes = new ArrayList<>();
        preorderHelper(root, preorderNodes);

        return preorderNodes;
    }

    void preorderHelper(TreeNode root, ArrayList<Integer> nodes)
    {
        if(root == null)
            return;

        nodes.add(root.val);
        preorderHelper(root.left, nodes);
        preorderHelper(root.left, nodes);
    }

    public TreeNode invertTree(TreeNode A) {
        if(A == null)
            return null;

        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;

        invertTree(A.left);
        invertTree(A.right);

        return A;
    }

    public int diameter(TreeNode A) {
        int[] diameter = new int[1];
        height(A, diameter);
        return diameter[0];
    }

    int height(TreeNode A, int[] diameter){
        if(A == null)
            return -1;
        int leftHeight = height(A.left, diameter);
        int rightHeight = height(A.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight + 2);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    void connect(TreeLinkNode root) {
        TreeLinkNode current = root;

        while(current != null)
        {
            TreeLinkNode temp = current;
            while(temp != null)
            {
                if(temp.left != null)
                {
                    temp.left.next = temp.right;
                }

                if(temp.next != null && temp.right != null)
                {
                    temp.right.next = temp.next.left;
                }

                temp = temp.next;
            }
            current = current.left;
        }

    }
}
