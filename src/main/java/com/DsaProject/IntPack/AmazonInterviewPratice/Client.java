package com.DsaProject.IntPack.AmazonInterviewPratice;

import java.util.*;

public class Client {

    public static void main(String[] args)
    {
        Solutions solutions = new Solutions();
        solutions.execute();
    }

    static void printArray(int[] nums)
    {
        for(int num : nums)
        {
            System.out.println(num);
        }
    }

    public static Node buildTree(String[] input) {
        if (input.length == 0 || input[0].equals("N")) return null;

        Node root = new Node(Integer.parseInt(input[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            Node current = queue.poll();

            // Left Child
            if (i < input.length && !input[i].equals("N")) {
                current.left = new Node(Integer.parseInt(input[i]));
                queue.add(current.left);
            }
            i++;

            // Right Child
            if (i < input.length && !input[i].equals("N")) {
                current.right = new Node(Integer.parseInt(input[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

}
