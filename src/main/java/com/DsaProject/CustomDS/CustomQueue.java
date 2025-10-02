package com.DsaProject.CustomDS;

import java.util.NoSuchElementException;

public class CustomQueue<T> {
    static final int InitialCapacity = 3;
    int front;
    int rear;
    Object[] elements;
    int size;

    public CustomQueue()
    {
        front = 0;
        rear = -1;
        elements = new Object[InitialCapacity];
        size = 0;
    }

    public void enqueue(T value)
    {
        ensureCapacity();
        rear = (rear + 1) % elements.length;
        elements[rear] = value;
        size++;
    }

    public T dequeue()
    {
        if(isEmpty())
            throw new NoSuchElementException("Queue is empty");
        T deletedelement = (T)elements[front];
        elements[front] = null;
        front = (front + 1) % elements.length;
        size--;
        return deletedelement;
    }

    public T poll()
    {
        if(isEmpty())
            throw new NoSuchElementException("Queue is empty");
        return (T)elements[front];
    }

    public int size()
    {
        return size;
    }

    void ensureCapacity()
    {
        if(size == elements.length)
        {
            int newLength = elements.length * 2;
            Object[] newArray = new Object[newLength];

            for(int i =0 ; i < size; i++)
            {
                newArray[i] = elements[(front + i) % elements.length];
            }

            elements =  newArray;
            front = 0;
            rear = size -1;
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
    }
}
