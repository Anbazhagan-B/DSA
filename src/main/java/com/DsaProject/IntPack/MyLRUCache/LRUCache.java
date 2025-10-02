package com.DsaProject.IntPack.MyLRUCache;

import java.util.*;

public class LRUCache <K, V> {
    int capacity;
    DoubleLinkedList<K, V> doubleLinkedList;
    Map<K, Node<K, V>> map;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        this.doubleLinkedList = new DoubleLinkedList<>();
        this.map = new HashMap<>();
    }

    public V get(K key)
    {
        if(!map.containsKey(key))
            throw new RuntimeException("Key is not found");
        Node node = map.get(key);
        doubleLinkedList.moveToFront(node);
        return (V)node.value;
    }

    public void put(K key, V value)
    {
        if(map.containsKey(key))
        {
            Node<K, V> node = map.get(key);
            node.value = value;
            doubleLinkedList.moveToFront(node);
        }
        else
        {
            if(map.size() >= capacity)
            {
                doubleLinkedList.removeLast();
                map.remove(key);
            }

            Node newNode = new Node<>(key, value);
            doubleLinkedList.addToFront(newNode);
            map.put(key, newNode);
        }
    }

    public void display()
    {
        doubleLinkedList.display();
    }

}
