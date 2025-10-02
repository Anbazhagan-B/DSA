package com.DsaProject.IntPack.supports;

public class Node
{
    public int data;
    public Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
    public Node (int d, Node left, Node right)
    {
        this.data = d;
        this.left = left;
        this.right = right;
    }
}