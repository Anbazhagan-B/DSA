package com.DsaProject.Thread;

public class StringRunnable implements Runnable{
    public void run()
    {
        int i =0;
        while (i < 100){
            System.out.println(i);
            i++;
        }
    }
}
