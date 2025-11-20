package com.DsaProject.IntPack.Threads;

public class Executor {

    Object lock1 = new Object();
    Object lock2 = new Object();

    public void execute()
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
