package com.DsaProject.LLD.CoffeeLLD;

import java.util.Map;

public class CoffeeRecipe {
    String name;
    int price;
    Map<String, Integer> recipe;

    public CoffeeRecipe(String name, int price, Map<String, Integer> recipe)
    {
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public String getName()
    {
        return this.name;
    }

    public int getPrice()
    {
        return this.price;
    }

    public Map<String, Integer> getRecipe()
    {
        return this.recipe;
    }

}
