package com.DsaProject.IntPack.Threads;

public class Executor {

    Object lock1 = new Object();
    Object lock2 = new Object();

    Couter couter = new Couter();
    public void multiThreading() {
        Thread thread1 = new Thread( () ->
        {
            //while (couter.count.get() < 100)
            while (couter.count < 100)
            {
                System.out.println("Thread 1:- "+ couter.getIncrementedValue());
            }
        });

        Thread thread2 = new Thread( () ->
        {
            //while (couter.count.get() < 100)
            while (couter.count < 100)
            {
                System.out.println("Thread 2:- " + couter.getIncrementedValue());
            }
        });

        thread1.start();
        thread2.start();
    }

    public void deadLockProgram()
    {
        Thread thread1 = new Thread(() -> {
            synchronized (lock1)
            {
                System.out.println("thread1 lock1 Executed");

                try
                {
                    Thread.sleep(100);

                    synchronized (lock2)
                    {
                        System.out.println("thread1 lock2 Executed");
                    }
                }
                catch (Exception ex)
                {

                }
            }
        });

        Thread thread2 = new Thread(() ->
        {
            synchronized (lock2)
            {
                System.out.println("thread2 lock2 Executed");
                try
                {
                    Thread.sleep(100);

                    synchronized (lock1)
                    {
                        System.out.println("thread2 lock1 Executed");
                    }
                }
                catch (Exception ex)
                {

                }
            }

        });

        thread1.start();
        thread2.start();
    }
}
