package com.DsaProject.IntPack.Threads;

public class ThreadExecutor extends  Thread{
    String name;

    public ThreadExecutor(String name)
    {
        this.name = name;
    }

    @Override
    public void run()
    {
        int i = 0;
        while(true)
        {
            System.out.println("Thread Name "+ this.name + ", Counter :- " + i++);
        }

    }
}
