package LLD2.StockBrokerSystem.state;

import LLD2.StockBrokerSystem.entities.Order;

public interface OrderState {
    void handle(Order order);
    void cancel(Order order);
}
