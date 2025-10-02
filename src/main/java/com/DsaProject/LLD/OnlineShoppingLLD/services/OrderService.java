package com.DsaProject.LLD.OnlineShoppingLLD.services;

import com.DsaProject.LLD.OnlineShoppingLLD.models.Customer;
import com.DsaProject.LLD.OnlineShoppingLLD.models.Order;
import com.DsaProject.LLD.OnlineShoppingLLD.models.OrderLineItem;
import com.DsaProject.LLD.OnlineShoppingLLD.models.ShoppingCart;

import java.util.*;

public class OrderService {
    InventoryService inventoryService;

    public OrderService(InventoryService inventoryService)
    {
        this.inventoryService = inventoryService;
    }

    public Order createOrder(Customer customer, ShoppingCart cart)
    {
        List<OrderLineItem> result = new ArrayList<>();
        cart.getItems().values().stream().map(cartItem -> new OrderLineItem(
                cartItem.getProduct().getId(),
                cartItem.getProduct().getName(),
                cartItem.getQuantity(),
                cartItem.getProduct().getPrice()
        )).forEach(result::add);

        inventoryService.updateStockForOrder(result);

        return new Order(customer, result, customer.getShippingAddress(), cart.calculateTotal());
    }
}
