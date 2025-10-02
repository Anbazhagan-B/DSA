package com.DsaProject.CustomDS;

import java.util.*;

public class CustomHashMap<K, V> {
    static final int DEFAULT_CAPACITY = 16;
    float loadFactor = 0.75f;
    int size = 0;
    MyEntry<K, V>[] table;

    public CustomHashMap()
    {
        table = new MyEntry[DEFAULT_CAPACITY];
    }

    int hash(K key)
    {
        return key == null ? 0 : Math.abs(key.hashCode()) % table.length;
    }

    public void put(K key, V value)
    {
        int index = hash(key);
        MyEntry<K, V> newEntry = new MyEntry<>(key, value);

        if(table[index] == null)
        {
            table[index] = newEntry;
        }
        else
        {
            MyEntry<K, V> current = table[index];
            MyEntry<K, V> prev = null;

            while (current != null)
            {
                if(current.key.equals(key))
                {
                    current.value = value;
                    return;
                }
                prev = current;
                current = current.next;
            }

            prev.next = newEntry;
        }

        size++;

        if((float)size/table.length > loadFactor)
        {
            resize();
        }

    }

    public V get(K key)
    {
        int index = hash(key);
        MyEntry<K, V> current = table[index];
        while (current != null)
        {
            if(current.key.equals(key))
            {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key)
    {
        int index = hash(key);
        MyEntry<K, V> valueInTable = table[index];
        MyEntry<K, V> prev = null;
        while (valueInTable != null)
        {
            if(valueInTable.key.equals(key))
            {
                if(prev == null)
                {
                    table[index] = valueInTable.next;
                }
                else
                {
                    prev.next = valueInTable.next;
                }
                size--;
                return;
            }

            prev = valueInTable;
            valueInTable = valueInTable.next;
        }

    }

    void resize()
    {
        MyEntry<K, V>[] oldTable = table;
        table = new MyEntry[table.length * 2];
        size = 0;
        for(MyEntry<K, V> entry : oldTable)
        {
            while (entry != null)
            {
                put(entry.key, entry.value);
                entry = entry.next;
            }
        }
    }
}
