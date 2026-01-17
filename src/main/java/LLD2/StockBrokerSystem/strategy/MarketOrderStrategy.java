package LLD2.StockBrokerSystem.strategy;

import LLD2.StockBrokerSystem.entities.Order;

public class MarketOrderStrategy implements ExecutionStrategy{
    @Override
    public boolean canExecute(Order order, double marketPrice) {
        return true;
    }
}
