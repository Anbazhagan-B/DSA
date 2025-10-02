package com.DsaProject.CustomDS;

import java.util.LinkedList;

public class CustomHashSet<T> {
    static final int Default_capacity = 16;
    LinkedList<T>[] buckets;

    int size ;

    public CustomHashSet()
    {
        buckets = new LinkedList[Default_capacity];
        for(int i =0; i < Default_capacity; i++)
        {
            buckets[i] = new LinkedList<>();
        }
        size = 0;
    }

    int hash(T key)
    {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public void add(T key)
    {
        int index = hash(key);

        if(!buckets[index].contains(key))
        {
            buckets[index].add(key);
            size++;
        }
    }

    public boolean contains(T key)
    {
        int index = hash(key);
        return buckets[index].contains(key);
    }

    public void remove(T key)
    {
        int index = hash(key);
        if(buckets[index].remove(key))
            size--;
    }

    public int size()
    {
        return size;
    }
}
