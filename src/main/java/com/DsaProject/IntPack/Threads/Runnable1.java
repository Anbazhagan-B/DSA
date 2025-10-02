package com.DsaProject.IntPack.Threads;

public class Runnable1 implements Runnable{

    String name;
    public Runnable1(String name)
    {
        this.name = name;
    }

    @Override
    public void run() {
        int i = 0;
        while(true)
        {
            System.out.println("Runnable1 Name "+ this.name + ", Counter :- " + i++);
        }
    }
}
