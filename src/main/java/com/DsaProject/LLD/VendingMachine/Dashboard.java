package com.DsaProject.LLD.VendingMachine;

import java.util.List;
import java.util.Scanner;

public class Dashboard {
    static VendingMachine vendingMachine = new VendingMachine();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)
    {
        Item item = new Item("5 star", 12);
        Item item1 = new Item("Dairy Milk", 15);
        vendingMachine.addStockItems(item);
        vendingMachine.addStockItems(item1);

        while (true)
        {
            System.out.println("Awesome Vendor");
            System.out.println("Enter the choice of yours");
            System.out.println("1. Select the Item of your Choice");
            System.out.println("2. Buy item");
            int choice = scanner.nextInt();

            switch (choice)
            {
                case 1:
                    displayItems();
                    break;
                case 2:
                default:
                    return;
            }
        }
    }


    static void displayItems()
    {
        List<Item> items =  vendingMachine.getAllItems();
        for(Item item : items)
        {
            System.out.println("Item "+ item.name + " , Item Price" + item.price);
        }
    }

    static void buyItem()
    {
        System.out.println("Enter SKU id");
        int skuCode = scanner.nextInt();

    }
}
