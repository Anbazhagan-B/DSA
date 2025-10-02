package com.DsaProject.IntPack.AmazonInterviewPratice.LinkedListProblems;


import java.util.*;


public class LinkedListProblems {

    public Node sortedInsert(Node head, int key) {
        Node newNode = new Node(key);

        Node traversalNode = head; Node prev = null; Node next = null ;

        while(traversalNode != null)
        {
            if(key <= traversalNode.data)
            {
                if(prev == null){
                    newNode.next = head;
                    head = newNode;
                    break;
                }
                else if(prev.data < key)
                {
                    next = traversalNode;
                    prev.next = newNode;
                    newNode.next = next;
                }
            }

            prev = traversalNode;
            traversalNode = traversalNode.next;
        }

        if(next == null && prev != null)
        {
            prev.next = newNode;
        }

        return head;
    }
    
    static ArrayList<Integer> removeDuplicate(int arr[]) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < arr.length; i++)
        {
            if(!result.contains(arr[i]))
            {
                result.add(arr[i]);
            }
        }
        return result;
    }

    public static Node deleteNode(Node head, int x) {
        // code here
        if(head == null || x < 0)
            return head;

        Node current = head;

        if(x == 1)
        {
            head = current.next;
            if(head != null)
            {
                head.prev = null;
            }
            return head;
        }

        for(int i = 1; current != null && i < x; i++)
        {
            current = current.next;
        }

        if(current == null)
            return  head;

        if(current.next != null)
            current.next.prev = current.prev;
        if(current.prev != null)
            current.prev.next = current.next;

        return head;
    }
}
