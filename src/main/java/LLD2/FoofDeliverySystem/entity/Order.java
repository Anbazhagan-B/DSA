package LLD2.FoofDeliverySystem.entity;

import LLD2.FoofDeliverySystem.enums.OrderStatus;
import LLD2.FoofDeliverySystem.observer.OrderObserver;

import java.util.*;

public class Order {
    String id;
    Restaurant restaurant;
    Customer customer;
    DeliveryAgent deliveryAgent;
    List<OrderItem> orderItems;
    OrderStatus orderStatus;
    List<OrderObserver>  orderObservers;

    public Order(Customer customer, Restaurant restaurant, List<OrderItem> orderItems)
    {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.orderItems = orderItems;
        this.restaurant = restaurant;
        this.orderStatus = OrderStatus.PENDING;

    }

    public void addObserver(OrderObserver orderObserver)
    {
        this.orderObservers.add(orderObserver);
    }

    public void updateObservers()
    {
        orderObservers.forEach(consumer -> consumer.onUpdate(this));
    }

    public void setOrderStatus(OrderStatus orderStatus)
    {
        if(this.orderStatus != null)
        {
            this.orderStatus = orderStatus;
            updateObservers();
        }
    }

    public boolean cancel()
    {
        if(orderStatus == OrderStatus.PENDING)
        {
            setOrderStatus(OrderStatus.CANCELLED);
            return true;
        }

        return false;
    }


    public void assignDeliveryAgent(DeliveryAgent agent)
    {
        this.deliveryAgent = agent;
        addObserver(this.deliveryAgent);
        agent.setAvailable(false);
    }

    public String getId() {
        return id;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public DeliveryAgent getDeliveryAgent() {
        return deliveryAgent;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public Customer getCustomer() {
        return customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

}
