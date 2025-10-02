package com.DsaProject.LLD.CoffeeLLD;

import java.util.*;

public class IngredientStore {
    Map<String, Integer> ingredients;

    public IngredientStore()
    {
        this.ingredients = new HashMap<>();
    }

    public void refill(String ingredient, int quantity)
    {
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0) + quantity);
    }

    public boolean hasEnoughIngredients(Map<String, Integer> required)
    {
        for(Map.Entry<String, Integer> requiredEntry: required.entrySet())
        {
            if(ingredients.containsKey(requiredEntry.getKey()) && ingredients.get(requiredEntry.getKey()) < requiredEntry.getValue())
            {
                return false;
            }
        }

        return true;
    }

    public void consume(Map<String, Integer> required)
    {
        for(Map.Entry<String, Integer> requiredEntry: required.entrySet())
        {
            ingredients.put(requiredEntry.getKey(), ingredients.getOrDefault(requiredEntry.getKey(), 0) - requiredEntry.getValue());
        }
    }

    public Map<String, Integer> getAllIngredients()
    {
        if(!ingredients.isEmpty())
        {
            return new HashMap<>(ingredients);
        }
        return null;
    }
}
