package LLD2.StockBrokerSystem.strategy;

import LLD2.StockBrokerSystem.entities.Order;

public interface ExecutionStrategy {
    boolean canExecute(Order order, double marketPrice);
}
