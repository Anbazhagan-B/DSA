package LLD2.VendingMachine.entity;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    Map<String, Item> items;
    Map<String, Integer> itemsWithQuantity;

    public Inventory()
    {
        this.items = new HashMap<>();
        this.itemsWithQuantity = new HashMap<>();
    }
    public void addItem(String itemCode, Item item, int quantity)
    {
        items.put(itemCode, item);
        itemsWithQuantity.put(itemCode, quantity);
    }

    public Item getItem(String itemCode)
    {
        return items.get(itemCode);
    }

    public void reduceQuantity(String itemCode)
    {
        itemsWithQuantity.put(itemCode, itemsWithQuantity.get(itemCode) - 1);
    }

    public boolean isAvailable(String itemCode)
    {
        return itemsWithQuantity.getOrDefault(itemCode, 0) > 0;
    }
}
