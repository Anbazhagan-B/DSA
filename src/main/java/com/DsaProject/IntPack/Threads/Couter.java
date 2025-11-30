package com.DsaProject.IntPack.Threads;

import java.util.concurrent.atomic.AtomicInteger;

public class Couter {
    //AtomicInteger count = new AtomicInteger(0);
    int count;
    public int getIncrementedValue()
    {
        return count++;
    }
}
