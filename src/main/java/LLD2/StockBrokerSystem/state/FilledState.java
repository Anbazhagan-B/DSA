package LLD2.StockBrokerSystem.state;

import LLD2.StockBrokerSystem.entities.Order;

public class FilledState implements OrderState{
    @Override
    public void handle(Order order) {
        System.out.println("Order is already filled ");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel a filled order");
    }
}
