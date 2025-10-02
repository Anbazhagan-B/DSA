package LLDProblems;

import java.util.*;

public class VendingMachine {
    // Inventory management
    private Map<String, Item> items;
    private Map<Coin, Integer> coinInventory;

    // Current transaction state
    private double currentBalance;
    private Item selectedItem;

    // Maintenance mode flag
    private boolean maintenanceMode;

    public VendingMachine() {
        items = new HashMap<>();
        coinInventory = new EnumMap<>(Coin.class);
        currentBalance = 0;
        maintenanceMode = false;
        initializeInventory();
    }

    private void initializeInventory() {
        // Initialize with some items
        items.put("A1", new Item("A1", "Coke", 1.25, 10));
        items.put("A2", new Item("A2", "Pepsi", 1.25, 10));
        items.put("B1", new Item("B1", "Chips", 0.75, 15));
        items.put("B2", new Item("B2", "Cookies", 1.00, 12));

        // Initialize coin inventory
        for (Coin coin : Coin.values()) {
            coinInventory.put(coin, 10); // Start with 10 of each coin
        }
    }

    // Coin enum representing different coin values
    public enum Coin {
        PENNY(0.01), NICKEL(0.05), DIME(0.10), QUARTER(0.25), DOLLAR(1.00);

        private final double value;

        Coin(double value) {
            this.value = value;
        }

        public double getValue() {
            return value;
        }
    }

    // Item class representing products in the vending machine
    public static class Item {
        private String code;
        private String name;
        private double price;
        private int quantity;

        public Item(String code, String name, double price, int quantity) {
            this.code = code;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        // Getters and setters
        public String getCode() { return code; }
        public String getName() { return name; }
        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }
        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }
    }

    // Public methods for vending machine operations

    public void insertCoin(Coin coin) {
        if (maintenanceMode) {
            System.out.println("Cannot accept coins in maintenance mode.");
            return;
        }
        currentBalance += coin.getValue();
        coinInventory.put(coin, coinInventory.get(coin) + 1);
        System.out.printf("Inserted: $%.2f, Current balance: $%.2f%n", coin.getValue(), currentBalance);
    }

    public void selectItem(String code) {
        if (maintenanceMode) {
            System.out.println("Cannot select items in maintenance mode.");
            return;
        }

        if (!items.containsKey(code)) {
            System.out.println("Invalid item code.");
            return;
        }

        Item item = items.get(code);
        if (item.getQuantity() <= 0) {
            System.out.println("Item out of stock.");
            return;
        }

        if (currentBalance < item.getPrice()) {
            System.out.printf("Insufficient funds. Price: $%.2f, Current balance: $%.2f%n",
                    item.getPrice(), currentBalance);
            return;
        }

        selectedItem = item;
        System.out.printf("Selected: %s - %s ($%.2f)%n",
                item.getCode(), item.getName(), item.getPrice());
    }

    public void purchaseItem() {
        if (maintenanceMode) {
            System.out.println("Cannot purchase items in maintenance mode.");
            return;
        }

        if (selectedItem == null) {
            System.out.println("No item selected.");
            return;
        }

        double changeAmount = currentBalance - selectedItem.getPrice();

        if (changeAmount < 0) {
            System.out.println("Insufficient funds.");
            return;
        }

        // Check if we can provide change
        if (!canMakeChange(changeAmount)) {
            System.out.println("Cannot provide exact change. Transaction cancelled.");
            return;
        }

        // Process the purchase
        selectedItem.setQuantity(selectedItem.getQuantity() - 1);
        System.out.printf("Dispensing: %s. Thank you for your purchase!%n", selectedItem.getName());

        // Dispense change if needed
        if (changeAmount > 0) {
            System.out.printf("Dispensing change: $%.2f%n", changeAmount);
            dispenseChange(changeAmount);
        }

        // Reset transaction state
        currentBalance = 0;
        selectedItem = null;
    }

    private boolean canMakeChange(double amount) {
        if (amount == 0) return true;

        // Make a copy of the coin inventory to simulate change dispensing
        Map<Coin, Integer> tempInventory = new EnumMap<>(coinInventory);

        double remaining = amount;
        // Try to make change starting with highest denomination
        Coin[] coins = Coin.values();
        Arrays.sort(coins, Collections.reverseOrder(Comparator.comparingDouble(Coin::getValue)));

        for (Coin coin : coins) {
            while (remaining >= coin.getValue() && tempInventory.get(coin) > 0) {
                remaining -= coin.getValue();
                tempInventory.put(coin, tempInventory.get(coin) - 1);
            }
        }

        return Math.abs(remaining) < 0.001; // Account for floating point precision
    }

    private void dispenseChange(double amount) {
        double remaining = amount;
        Coin[] coins = Coin.values();
        Arrays.sort(coins, Collections.reverseOrder(Comparator.comparingDouble(Coin::getValue)));

        for (Coin coin : coins) {
            while (remaining >= coin.getValue() && coinInventory.get(coin) > 0) {
                remaining -= coin.getValue();
                coinInventory.put(coin, coinInventory.get(coin) - 1);
                System.out.printf("Dispensed: $%.2f%n", coin.getValue());
            }
        }
    }

    public void cancelTransaction() {
        if (maintenanceMode) {
            System.out.println("No transaction to cancel in maintenance mode.");
            return;
        }

        if (currentBalance > 0) {
            System.out.printf("Returning $%.2f%n", currentBalance);
            dispenseChange(currentBalance);
        }

        currentBalance = 0;
        selectedItem = null;
    }

    // Maintenance mode methods

    public void enterMaintenanceMode(String password) {
        if ("admin123".equals(password)) {
            maintenanceMode = true;
            System.out.println("Entered maintenance mode.");
        } else {
            System.out.println("Invalid password.");
        }
    }

    public void exitMaintenanceMode() {
        maintenanceMode = false;
        System.out.println("Exited maintenance mode.");
    }

    public void restockItem(String code, int quantity) {
        if (!maintenanceMode) {
            System.out.println("Must be in maintenance mode to restock.");
            return;
        }

        if (!items.containsKey(code)) {
            System.out.println("Invalid item code.");
            return;
        }

        Item item = items.get(code);
        item.setQuantity(item.getQuantity() + quantity);
        System.out.printf("Restocked %s - %s. New quantity: %d%n",
                item.getCode(), item.getName(), item.getQuantity());
    }

    public void updateItemPrice(String code, double newPrice) {
        if (!maintenanceMode) {
            System.out.println("Must be in maintenance mode to update prices.");
            return;
        }

        if (!items.containsKey(code)) {
            System.out.println("Invalid item code.");
            return;
        }

        Item item = items.get(code);
        double oldPrice = item.getPrice();
        item.setPrice(newPrice);
        System.out.printf("Updated price for %s - %s from $%.2f to $%.2f%n",
                item.getCode(), item.getName(), oldPrice, newPrice);
    }

    public void addNewItem(String code, String name, double price, int quantity) {
        if (!maintenanceMode) {
            System.out.println("Must be in maintenance mode to add items.");
            return;
        }

        if (items.containsKey(code)) {
            System.out.println("Item code already exists.");
            return;
        }

        items.put(code, new Item(code, name, price, quantity));
        System.out.printf("Added new item: %s - %s ($%.2f, Qty: %d)%n",
                code, name, price, quantity);
    }

    public void restockCoins(Coin coin, int quantity) {
        if (!maintenanceMode) {
            System.out.println("Must be in maintenance mode to restock coins.");
            return;
        }

        coinInventory.put(coin, coinInventory.get(coin) + quantity);
        System.out.printf("Restocked %s coins. New quantity: %d%n",
                coin.name(), coinInventory.get(coin));
    }

    public void displayInventory() {
        System.out.println("\nCurrent Inventory:");
        System.out.println("-----------------");
        for (Item item : items.values()) {
            System.out.printf("%s - %s: $%.2f (%d available)%n",
                    item.getCode(), item.getName(),
                    item.getPrice(), item.getQuantity());
        }

        System.out.println("\nCoin Inventory:");
        System.out.println("---------------");
        for (Coin coin : Coin.values()) {
            System.out.printf("%s: %d available%n", coin.name(), coinInventory.get(coin));
        }
    }

    public static void main(String[] args) {
        VendingMachine vm = new VendingMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVending Machine Menu:");
            if (!vm.maintenanceMode) {
                System.out.println("1. Insert Coin");
                System.out.println("2. Select Item");
                System.out.println("3. Purchase Selected Item");
                System.out.println("4. Cancel Transaction");
                System.out.println("5. Display Inventory");
                System.out.println("6. Enter Maintenance Mode");
                System.out.println("7. Exit");
            } else {
                System.out.println("MAINTENANCE MODE:");
                System.out.println("1. Restock Item");
                System.out.println("2. Update Item Price");
                System.out.println("3. Add New Item");
                System.out.println("4. Restock Coins");
                System.out.println("5. Display Inventory");
                System.out.println("6. Exit Maintenance Mode");
                System.out.println("7. Exit Program");
            }

            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                if (!vm.maintenanceMode) {
                    switch (choice) {
                        case 1:
                            System.out.println("Enter coin type (PENNY, NICKEL, DIME, QUARTER, DOLLAR): ");
                            String coinType = scanner.nextLine().toUpperCase();
                            try {
                                Coin coin = Coin.valueOf(coinType);
                                vm.insertCoin(coin);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid coin type.");
                            }
                            break;
                        case 2:
                            System.out.println("Enter item code: ");
                            String code = scanner.nextLine().toUpperCase();
                            vm.selectItem(code);
                            break;
                        case 3:
                            vm.purchaseItem();
                            break;
                        case 4:
                            vm.cancelTransaction();
                            break;
                        case 5:
                            vm.displayInventory();
                            break;
                        case 6:
                            System.out.println("Enter maintenance password: ");
                            String password = scanner.nextLine();
                            vm.enterMaintenanceMode(password);
                            break;
                        case 7:
                            System.out.println("Exiting...");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Invalid choice.");
                    }
                } else {
                    switch (choice) {
                        case 1:
                            System.out.println("Enter item code to restock: ");
                            String restockCode = scanner.nextLine().toUpperCase();
                            System.out.println("Enter quantity to add: ");
                            int restockQty = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            vm.restockItem(restockCode, restockQty);
                            break;
                        case 2:
                            System.out.println("Enter item code to update price: ");
                            String priceCode = scanner.nextLine().toUpperCase();
                            System.out.println("Enter new price: ");
                            double newPrice = scanner.nextDouble();
                            scanner.nextLine(); // consume newline
                            vm.updateItemPrice(priceCode, newPrice);
                            break;
                        case 3:
                            System.out.println("Enter new item code: ");
                            String newCode = scanner.nextLine().toUpperCase();
                            System.out.println("Enter item name: ");
                            String newName = scanner.nextLine();
                            System.out.println("Enter item price: ");
                            double price = scanner.nextDouble();
                            System.out.println("Enter initial quantity: ");
                            int qty = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            vm.addNewItem(newCode, newName, price, qty);
                            break;
                        case 4:
                            System.out.println("Enter coin type to restock (PENNY, NICKEL, DIME, QUARTER, DOLLAR): ");
                            String coinType = scanner.nextLine().toUpperCase();
                            System.out.println("Enter quantity to add: ");
                            int coinQty = scanner.nextInt();
                            scanner.nextLine(); // consume newline
                            try {
                                Coin coin = Coin.valueOf(coinType);
                                vm.restockCoins(coin, coinQty);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Invalid coin type.");
                            }
                            break;
                        case 5:
                            vm.displayInventory();
                            break;
                        case 6:
                            vm.exitMaintenanceMode();
                            break;
                        case 7:
                            System.out.println("Exiting...");
                            scanner.close();
                            return;
                        default:
                            System.out.println("Invalid choice.");
                    }
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // clear buffer
            }
        }
    }
}