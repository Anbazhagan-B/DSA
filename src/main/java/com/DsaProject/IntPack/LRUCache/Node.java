package com.DsaProject.IntPack.LRUCache;

public class Node<K, V> {
    public K key;
    public V value;
    Node<K, V> prev, next;

    public Node(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}
