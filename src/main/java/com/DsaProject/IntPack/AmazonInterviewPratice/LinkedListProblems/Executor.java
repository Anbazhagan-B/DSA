package com.DsaProject.IntPack.AmazonInterviewPratice.LinkedListProblems;

public class Executor {

    static LinkedListProblems linkedListProblems = new LinkedListProblems();
    public static void main(String[] args)
    {
        Node list1 = new Node(25);
        list1.next = new Node(35);
        list1.next.next = new Node(47);
        list1.next.next.next = new Node(58);
        list1.next.next.next.next = new Node(69);
        list1.next.next.next.next.next = new Node(80);
        Node node = linkedListProblems.sortedInsert(list1, 19);
        printLinkedList(node);
    }

    static void printLinkedList(Node node)
    {
        while (node != null)
        {
            System.out.println(node.data);
            node = node.next;
        }
    }
}
