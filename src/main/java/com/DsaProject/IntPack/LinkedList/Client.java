package com.DsaProject.IntPack.LinkedList;

public class Client {

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        reverseList(head);
    }

    static Node reverseList(Node head) {
       Node current = head, next = null, prev = null;

       while (current != null)
       {
           prev = current.next;
           current = current.next;
           current.next = prev;
           prev = next;
       }

       return prev;
    }
}
