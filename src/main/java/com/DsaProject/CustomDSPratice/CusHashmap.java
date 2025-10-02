package com.DsaProject.CustomDSPratice;

import org.springframework.boot.context.event.SpringApplicationEvent;

public class CusHashmap<TK, TV> {
    public MapEntry<TK, TV>[] elements;
    public int size;
    int hash(TK key)
    {
        return key == null ? 0 : Math.abs(key.hashCode() % elements.length);
    }

    public void put(TK key, TV value)
    {
        MapEntry<TK, TV> newValue = new MapEntry<>(key, value);
        int index = hash(key);

        if(elements[index] == null)
        {
            elements[index] = newValue;
        }
        else
        {
            var current = elements[index];
            MapEntry prev = null;

            while (current != null)
            {
                if(current.key == key)
                {
                    return;
                }

                prev = current;
                current = current.next;
            }

            prev.next = newValue;
        }
    }

    public TV get(TK key)
    {
        int index = hash(key);
        MapEntry current = elements[index];

        while (current != null)
        {
            if(current.key.equals(key))
            {
                return (TV)current.value;
            }
            current = current.next;
        }

        return null;
    }

    public void remove(TK key){
        int index = hash(key);
        MapEntry valueInTable = elements[index];
        MapEntry prev = null;
        while (valueInTable != null)
        {
            if(valueInTable.key.equals(key))
            {
                if(prev == null)
                {
                    elements[index] = valueInTable.next;
                }
                else
                {
                    prev.next = valueInTable.next;
                }
                size--;
            }

            prev = valueInTable;
            valueInTable = valueInTable.next;
        }
    }

}
