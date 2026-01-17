package LLD2.StockBrokerSystem.strategy;

import LLD2.StockBrokerSystem.entities.Order;
import LLD2.StockBrokerSystem.enums.TransactionType;

public class LimitOrderStrategy implements ExecutionStrategy{

    final TransactionType type;

    public LimitOrderStrategy(TransactionType type)
    {
        this.type = type;
    }

    @Override
    public boolean canExecute(Order order, double marketPrice) {
        if(type == TransactionType.BUY)
        {
            return marketPrice <= order.getPrice();
        }
        else
        {
            return marketPrice >= order.getPrice();
        }
    }
}
