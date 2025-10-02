package com.DsaProject.LLD.CoffeeLLD;

import java.util.HashMap;
import java.util.Map;

public class CoffeeVendingMachine {
    Map<String, CoffeeRecipe> recipes;
    IngredientStore ingredientStore;
    Dispenser dispenser;
    PaymentProcessor paymentProcessor;

    public CoffeeVendingMachine()
    {
        recipes = new HashMap<>();
        ingredientStore = new IngredientStore();
        dispenser = new Dispenser();
        paymentProcessor = new PaymentProcessor();
        addDefaultRecipes();
    }

    public void addDefaultRecipes()
    {
        recipes.put("Espresso", new CoffeeRecipe("Espresso", 10, Map.of("Water", 10, "Coffee", 20)));
        recipes.put("Cappuccino", new CoffeeRecipe("Cappuccino", 10, Map.of("Water", 50, "Coffee", 20, "Milk", 40)));
        recipes.put("Latte", new CoffeeRecipe("Latte", 10,Map.of("Water", 50, "Coffee", 20, "Milk", 30)));
    }

    public synchronized CoffeeRecipe selectCoffee(String ingredientName)
    {
        if(!recipes.containsKey(ingredientName))
        {
            throw new RuntimeException(ingredientName +" not found");
        }

        return recipes.get(ingredientName);
    }

    public void displayMenu()
    {
        System.out.println("Coffee Menu:");
        for (String coffee: recipes.keySet())
        {
            System.out.println("Coffee Name: "+ coffee + ", Price :- "+ recipes.get(coffee).getPrice());
        }
    }

    public synchronized void dispenseCoffee(CoffeeRecipe coffeeRecipe, Payment payment)
    {
        if(payment.getAmount() < coffeeRecipe.price)
        {
            throw new RuntimeException("Amount is not enough for" + coffeeRecipe.getName() +". Worked hard and earn the money");
        }
        if(!ingredientStore.hasEnoughIngredients(coffeeRecipe.getRecipe()))
        {
            throw new RuntimeException("Store is not capable of providing u" + coffeeRecipe.getName());
        }
        ingredientStore.consume(coffeeRecipe.getRecipe());
        paymentProcessor.processPayment(payment);

        dispenser.prepareDrink(coffeeRecipe);
    }

    public void refillIngredient(String ingredientName, int quantity)
    {
        ingredientStore.refill(ingredientName, quantity);
    }

    public static CoffeeVendingMachine getInstance()
    {
        return new CoffeeVendingMachine();
    }
}
