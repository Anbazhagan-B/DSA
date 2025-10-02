package com.DsaProject.DataStructureModels;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) {
        val = x;
        left=null;
        right=null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void setLeft(TreeNode left)
    {
        this.left = left;
    }

    public void setRight(TreeNode right)
    {
        this.right = right;
    }
}

