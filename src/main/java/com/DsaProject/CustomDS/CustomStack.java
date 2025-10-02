package com.DsaProject.CustomDS;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class CustomStack<T> {
    static final int Default_capacity = 10;
    Object[] elements;
    int size;

    public CustomStack()
    {
        elements = new Object[Default_capacity];
        size = 0;
    }

    public void push(T value)
    {
        ensureCapacity();
        elements[size++] = value;
    }

    public T pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }

        T deletedValue = (T) elements[--size];
        elements[size] = null;
        return deletedValue;
    }

    public T peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }

        return (T)elements[size -1];
    }

    public int size()
    {
        return size;
    }

    boolean isEmpty()
    {
        return size == 0;
    }

    void ensureCapacity()
    {
        if(size == elements.length)
        {
            int newLength = elements.length * 2;
            Object[] newElements = new Object[newLength];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }
}
