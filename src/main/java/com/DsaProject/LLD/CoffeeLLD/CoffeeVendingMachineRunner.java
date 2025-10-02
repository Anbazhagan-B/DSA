package com.DsaProject.LLD.CoffeeLLD;

public class CoffeeVendingMachineRunner {
    public static void main(String[] args)
    {
        CoffeeVendingMachine coffeeVendingMachine = CoffeeVendingMachine.getInstance();

        coffeeVendingMachine.refillIngredient("Water", 120);
        coffeeVendingMachine.refillIngredient("Milk", 70);
        coffeeVendingMachine.refillIngredient("Coffee", 150);

        // Display coffee menu
        coffeeVendingMachine.displayMenu();

        // Simulate user requests
        CoffeeRecipe espresso = coffeeVendingMachine.selectCoffee("Espresso");
        coffeeVendingMachine.dispenseCoffee(espresso, new Payment(10));

        CoffeeRecipe cappuccino = coffeeVendingMachine.selectCoffee("Cappuccino");
        coffeeVendingMachine.dispenseCoffee(cappuccino, new Payment(20));


        CoffeeRecipe latte = coffeeVendingMachine.selectCoffee("Latte");
        coffeeVendingMachine.dispenseCoffee(latte, new Payment(40));
    }
}
