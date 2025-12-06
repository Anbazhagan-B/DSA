package com.DsaProject.IntPack.Threads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args)
    {
        Executor executor = new Executor();
        executor.fibonacciSeries();

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        Runnable1 runnable1 = new Runnable1("Runnable");
//        executorService.submit(runnable1);
    }
}
