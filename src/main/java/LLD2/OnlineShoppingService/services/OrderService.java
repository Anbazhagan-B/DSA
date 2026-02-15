package LLD2.OnlineShoppingService.services;

import LLD2.OnlineShoppingService.models.Customer;
import LLD2.OnlineShoppingService.models.Order;
import LLD2.OnlineShoppingService.models.OrderLineItem;
import LLD2.OnlineShoppingService.models.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    final InventoryService inventoryService;

    public OrderService(InventoryService inventoryService)
    {
        this.inventoryService = inventoryService;
    }

    public Order createOrder(Customer customer, ShoppingCart cart)
    {
        List<OrderLineItem> result = new ArrayList<>();
        cart.getItems().values().stream().map(cartItem ->
                new OrderLineItem(cartItem.getProduct().getId(), cartItem.getProduct().getName(), cartItem.getQuantity(), cartItem.getProduct().getPrice()))
                .forEach(result::add);
        inventoryService.updateStockForOrder(result);

        return new Order(customer, result, customer.getShippingAddress(), cart.calculateTotal());

    }
}
