package com.DsaProject.LLD.FoodDeliveryServiceLLD.order;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.entity.Customer;
import com.DsaProject.LLD.FoodDeliveryServiceLLD.entity.DeliveryAgent;
import com.DsaProject.LLD.FoodDeliveryServiceLLD.entity.Restaurant;
import com.DsaProject.LLD.FoodDeliveryServiceLLD.observer.OrderObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    String id;
    Customer customer;
    Restaurant restaurant;
    List<OrderItem> items;
    OrderStatus status;
    DeliveryAgent deliveryAgent;
    List<OrderObserver> observers = new ArrayList<>();

    public Order(Customer customer, Restaurant restaurant, List<OrderItem> items)
    {
        this.id = UUID.randomUUID().toString();
        this.customer = customer;
        this.restaurant = restaurant;
        this.items = items;
        this.status = OrderStatus.PENDING;
        addObserver(customer);
        addObserver(restaurant);
    }

    public void addObserver(OrderObserver observer)
    {
        observers.add(observer);
    }
    private void notifyObservers()
    {
        observers.forEach(o -> o.onUpdate(this));
    }

    public void setStatus(OrderStatus newStatus)
    {
        if(this.status != newStatus)
        {
            this.status = newStatus;
            notifyObservers();
        }
    }

    public boolean cancel()
    {
        if(this.status == OrderStatus.PENDING)
        {
            setStatus(OrderStatus.CANCELLED);
            return true;
        }

        return false;
    }

    public void assignDeliveryAgent(DeliveryAgent agent)
    {
        this.deliveryAgent = agent;
        addObserver(agent);
        agent.setIsAvailable(false);
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public DeliveryAgent getDeliveryAgent() {
        return deliveryAgent;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
