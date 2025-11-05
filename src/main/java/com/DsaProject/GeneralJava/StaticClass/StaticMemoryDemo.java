package com.DsaProject.GeneralJava.StaticClass;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaticMemoryDemo {

    // Instance variable - stored in heap (per object)
    private int instanceCount = 0;

    // Static variable - stored in Method Area (one copy for all)
    private static int staticCount = 0;

    // Static block - executed once when class loads
    static {
        System.out.println("Class loaded");
        staticCount = 100;
    }

    public StaticMemoryDemo() {
        instanceCount++;
        staticCount++;
    }

    public static void processFile() throws IOException {
        FileReader file = null;

        try {
            file = new FileReader("data.txt");
            // Process file
            int data = file.read();

        } finally {
            // Cleanup always happens
            if(file != null) {
                file.close();  // Close resource
            }
            System.out.println("File closed");
        }
        // Exception propagates to caller
    }

    public static int testFinally() {
        try {
            System.out.println("Try block");
            return 1;  // Return from try

        } catch (Exception e) {
            System.out.println("Catch block");
            return 2;  // Return from catch

        } finally {
            System.out.println("Finally block");  // Still executes!
            // Even though return already happened
        }
    }

    public static void main(String[] args) {

        Integer nullInteger = null;



        try {
            int value = nullInteger;  // ❌ NullPointerException!
            // Internally: int value = nullInteger.intValue();
            // But nullInteger is null → NPE!
        } catch(NullPointerException e) {
            System.out.println("NPE caught: Cannot unbox null");
        }


        StaticMemoryDemo obj1 = new StaticMemoryDemo();
        StaticMemoryDemo obj2 = new StaticMemoryDemo();
        StaticMemoryDemo obj3 = new StaticMemoryDemo();

        // Each object has own instanceCount
        System.out.println(obj1.instanceCount); // 1
        System.out.println(obj2.instanceCount); // 1
        System.out.println(obj3.instanceCount); // 1

        // All share same staticCount
        System.out.println(staticCount); // 103
    }

    // MEMORY LEAK WARNING: Static collections
    private static List<Object> cache = new ArrayList<>();

    public void addToCache(Object obj) {
        cache.add(obj);  // Lives until class unloads - potential leak!
    }

    // Memory layout:
    // Heap: obj1, obj2, obj3 (each with instanceCount)
    // Method Area: staticCount (one copy), cache (one copy)
}
