package LLD2.OnlineShoppingService.models;

import LLD2.OnlineShoppingService.enums.OrderStatus;
import LLD2.OnlineShoppingService.observer.Subject;
import com.DsaProject.LLD.OnlineShoppingLLD.models.OrderLineItem;

import java.time.LocalDateTime;
import java.util.*;
import java.util.UUID;

public class Order extends Subject {
    private final String id;
    private final Customer customer;
    private final List<OrderLineItem> items;
    private final Address shippingAddress;
    private final double totalAmount;
    private final LocalDateTime orderDate;
    private OrderStatus status;
    private OrderState currentState;

    public Order(Customer customer, List<OrderLineItem> items, Address shippingAddress, double totalAmount)
    {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.customer = customer;
        this.items = items;
        
    }
}
