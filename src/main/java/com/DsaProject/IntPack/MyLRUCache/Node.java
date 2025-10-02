package com.DsaProject.IntPack.MyLRUCache;

public class  Node <K, V>{
    K key;
    V value;
    public Node<K, V> prev, next;

    public Node(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}
