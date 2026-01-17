package LLD2.StockBrokerSystem.state;

import LLD2.StockBrokerSystem.entities.Order;
import LLD2.StockBrokerSystem.enums.OrderStatus;

public class OpenState implements OrderState{
    @Override
    public void handle(Order order) {
        System.out.println("Order is open and waiting for execution. ");
    }

    @Override
    public void cancel(Order order) {
        order.setStatus(OrderStatus.CANCELLED);
        order.setState(new CancelledState());
        System.out.println("Order "+ order.getOrderId() + " has been cancelled");
    }
}

