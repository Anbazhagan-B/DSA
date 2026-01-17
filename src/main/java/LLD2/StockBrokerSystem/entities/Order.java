package LLD2.StockBrokerSystem.entities;

import LLD2.StockBrokerSystem.enums.*;
import LLD2.StockBrokerSystem.state.*;
import LLD2.StockBrokerSystem.strategy.ExecutionStrategy;

public class Order {
    final String orderId;
    final User user;
    final Stock stock;
    final OrderType type;
    final int quantity;
    final double price;
    OrderStatus status;
    User owner;
    OrderState currentState;
    final ExecutionStrategy executionStrategy;

    public Order(String orderId, User user, Stock stock, OrderType type, int quantity, double price, ExecutionStrategy strategy, User owner)
    {
        this.orderId = orderId;
        this.user = user;
        this.stock = stock;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.executionStrategy = strategy;
        this.owner = owner;
        this.currentState = new OpenState();
        this.status = OrderStatus.OPEN;
    }

    public void cancel()
    {
        currentState.cancel(this);
    }

    public String getOrderId()
    {
        return orderId;
    }
    public User getUser()
    {
        return user;
    }

    public Stock getStock()
    {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public ExecutionStrategy getExecutionStrategy() {
        return executionStrategy;
    }
    public OrderType getType() { return type; }

    public void setState(OrderState state){this.currentState = state; }

    public void setStatus(OrderStatus status) {
        this.status = status;
        notifyOwner();
    }

    private void notifyOwner()
    {
        if(owner != null)
        {
            owner.orderStatusUpdate(this);
        }
    }
}
