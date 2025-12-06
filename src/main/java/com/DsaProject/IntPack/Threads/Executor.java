package com.DsaProject.IntPack.Threads;

import com.DsaProject.Prods.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class Executor {

    Object lock1 = new Object();
    Object lock2 = new Object();


    DatabaseConnection databaseConnection = () -> { System.out.println("Add Connection"); };

    public void fibonacciSeries()
    {
        List<Integer> fibNumbers = new ArrayList<>();
        FibonacciHelper1(8, fibNumbers);
        System.out.println("fibonacciSeries :- " + fibNumbers);
    }

    private void groupByEmployeeSalary(List<Employee> employees)
    {
        employees.add(new Employee("Ajay", "IT", 2000));
        employees.add(new Employee("Ton", "IT", 3000));
        employees.add(new Employee("Berry", "IT", 3000));
        employees.add(new Employee("Dom", "IT", 6000));
        employees.add(new Employee("Anbu", "IT", 6000));
        Map<Integer, List<Employee>> emp = employees.stream().collect(Collectors.groupingBy(Employee::getSalary));
    }

    private int FibonacciHelper1(int num, List<Integer> fibNumbers)
    {
        System.out.println("Num :- " + num);
        if(num == 0 || num == 1)
        {
            fibNumbers.add(num);
            return num;
        }
        int result =  FibonacciHelper1(num - 1, fibNumbers) + FibonacciHelper1(num - 2, fibNumbers);
        fibNumbers.add(result);

        return result;
    }

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
