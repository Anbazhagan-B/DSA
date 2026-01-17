package LLD2.StockBrokerSystem.state;

import LLD2.StockBrokerSystem.entities.Order;
import LLD2.StockBrokerSystem.enums.OrderStatus;

public class CancelledState implements OrderState{
    @Override
    public void handle(Order order) {
        System.out.println("Order is cancelled ");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order is already cancelled");
    }
}
