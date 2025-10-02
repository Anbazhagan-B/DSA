package com.DsaProject.CustomDS;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CustomArrayList<T> {

    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    public T get(int index)
    {
        checkForValidIndex(index);
        return (T) elements[index];
    }

    public void add(T value)
    {
        checkCapacity();
        elements[size++] = value;
    }

    public void remove(int index) {
        checkForValidIndex(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    public int size()
    {
        return size;
    }

    void checkCapacity()
    {
        if(size >= elements.length)
        {
            int newLength = elements.length * 2;
            Arrays.copyOf(elements, newLength);
        }
    }

    void checkForValidIndex(int index) {
        if(index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("Index Out of Bound Exception");
    }

}
