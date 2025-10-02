package com.DsaProject.IntPack.MyLRUCache;

public class DoubleLinkedList <K , V>{
    private Node<K, V> head, tail;

    //addFirst, -> assign to head, and assign to tail if tail is empty
    public void addToFront(Node node)
    {
       if(head == null)
       {
           head = node;
           tail = node;
       }
       else
       {
           node.next = head;
           head.prev = node;
           head = node;
       }
    }
    //  moveFront -> remove , addFirst

    public void moveToFront(Node node)
    {
        if(node == head) return;
        remove(node);
        addToFront(node);
    }

    // removeLast, -> remove last node from tail
    public Node removeLast()
    {
        if(tail == null) return null;
        Node node = tail;
        remove(node);
        return node;
    }

    public void remove(Node node)
    {
        if(node.prev != null)
        {
            node.prev.next = node.next;
        }
        else
            head = node.prev;

        if(node.next != null)
        {
            node.next.prev = node.prev;
        }
        else
            tail = node.prev;
    }

    void display()
    {
        Node traversalNode = head;
        while (traversalNode != null)
        {
            System.out.println("Key :- "+ traversalNode.key + ", Value :- " + traversalNode.value);
            traversalNode = traversalNode.next;
        }
    }
}
