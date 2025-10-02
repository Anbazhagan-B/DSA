package com.DsaProject.IntPack.MyLRUCache;

import java.util.Scanner;

public class Client {
    public static void main(String[] args)
    {
        LRUCache lruCache = new LRUCache(10);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter LRU cache capacity: ");
        int capacity = scanner.nextInt();
        LRUCache<Integer, String> cache = new LRUCache(capacity);

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Put (key, value)");
            System.out.println("2. Get (key)");
            System.out.println("3. Display cache");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key (integer): ");
                    int key = scanner.nextInt();
                    System.out.print("Enter value (string): ");
                    String value = scanner.next();
                    cache.put(key, value);
                    System.out.println("Added to cache: (" + key + ", " + value + ")");
                    break;

                case 2:
                    System.out.print("Enter key to get: ");
                    int getKey = scanner.nextInt();
                    String result = String.valueOf(cache.get(getKey));
                    if (result == null) {
                        System.out.println("Key " + getKey + " not found in cache");
                    } else {
                        System.out.println("Value for key " + getKey + ": " + result);
                    }
                    break;

                case 3:
                    System.out.println("Current cache contents:");
                    cache.display();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
