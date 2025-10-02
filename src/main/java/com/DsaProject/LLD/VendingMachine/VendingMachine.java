package com.DsaProject.LLD.VendingMachine;

import java.util.*;

public class VendingMachine {
    Map<Integer, Item> stockItem = new HashMap<>();
    UserSession userSession;

    public void addStockItems(Item item)
    {
        stockItem.put(item.id, item);
    }

    public List<Item> getAllItems()
    {
        return this.stockItem.values().stream().toList();
    }

    public void setUserSession(UserSession userSession)
    {
        this.userSession = userSession;
    }

    public UserSession getUserSession()
    {
        return this.userSession;
    }
}
