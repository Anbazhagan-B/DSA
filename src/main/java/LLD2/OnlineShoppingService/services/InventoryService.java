package LLD2.OnlineShoppingService.services;

import LLD2.OnlineShoppingService.exceptions.OutOfStockException;
import LLD2.OnlineShoppingService.models.OrderLineItem;
import LLD2.OnlineShoppingService.models.Product;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
    final Map<String, Integer> stock;

    public InventoryService()
    {
        this.stock = new ConcurrentHashMap<>();
    }

    public void addStock(Product product, int quantity)
    {
        stock.put(product.getId(), stock.getOrDefault(product.getId(), 0) + quantity);
    }

    public synchronized void updateStockForOrder(List<OrderLineItem> items)
    {
        for(OrderLineItem item : items)
        {
            if(stock.getOrDefault(item.getProductId(), 0) < item.getQuantity())
            {
                throw new OutOfStockException("Not enough stock for product ID: " + item.getProductId());
            }
        }

        for(OrderLineItem item : items)
        {
            stock.compute(item.getProductId(), (id, currentStock) -> currentStock - item.getQuantity());
        }
    }
}
