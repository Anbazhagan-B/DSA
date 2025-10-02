package com.DsaProject.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TheardProblems {
    public static void main(String[] args)
    {
//        StringRunnable stringRunnable = new StringRunnable();
//        Thread stringThread = new Thread(stringRunnable);
//        stringThread.start();

        System.out.println("ExecutorService Started- ");
        try
        {
            Adder adder = new Adder(10);
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future<ArrayList<Integer>> arrayList = executorService.submit(adder);
            ArrayList<Integer> arr = arrayList.get();
            System.out.println("ExecutorService result :- " + arr);
        }
        catch (Exception e)
        {
            System.out.println("Exception" + e);
        }
    }
}
