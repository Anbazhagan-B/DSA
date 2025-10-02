package com.DsaProject.IntPack;

import java.util.*;

public class ZigzagIterator {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    boolean takeFromQueue2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue1 = new LinkedList<>(v1);
        queue2 = new LinkedList<>(v2);
        takeFromQueue2 = false;
    }

    public int next() {
        int nextNumber = 0;
        if(takeFromQueue2)
        {
            if(!queue2.isEmpty())
            {
                nextNumber = queue2.poll();
            }
            else if(!queue1.isEmpty())
            {
                nextNumber = queue1.poll();
            }
        }
        else
        {
            if(!queue1.isEmpty())
            {
                nextNumber = queue1.poll();
            }
            else if(!queue2.isEmpty())
            {
                nextNumber = queue2.poll();
            }
        }
        takeFromQueue2 = !takeFromQueue2;
        return nextNumber;
    }

    public boolean hasNext() {
        boolean hasNext = false;
        if(takeFromQueue2 && !queue2.isEmpty())
        {
            hasNext = true;
        }
        else if(!queue1.isEmpty())
        {
            hasNext = true;
        }
        return hasNext;
    }
}
