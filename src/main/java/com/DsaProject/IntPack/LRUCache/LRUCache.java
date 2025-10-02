package com.DsaProject.IntPack.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache{
    int capacity;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedList dll;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.dll = new DoubleLinkedList();
    }

    public int get(int key)
    {
        if(!map.containsKey(key))
        {
            return -1;
        }

        Node<Integer, Integer> tailElement = map.get(key);
        dll.moveToFront(tailElement);
        return  tailElement.value;
    }

    public void put(int key, int value)
    {
        if(map.containsKey(key))
        {
            Node<Integer, Integer>  node = map.get(key);
            node.value = value;
            dll.moveToFront(node);
        }
        else
        {
            if(map.size() >= capacity)
            {
                Node<Integer, Integer> lru = dll.removeLast();
                map.remove(lru.key);
            }
            Node<Integer,Integer> newNode = new Node<>(key, value);
            dll.addFirst(newNode);
            map.put(key, newNode);
        }
    }
}
