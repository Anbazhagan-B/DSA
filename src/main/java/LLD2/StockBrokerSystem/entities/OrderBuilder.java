package LLD2.StockBrokerSystem.entities;

import LLD2.StockBrokerSystem.enums.OrderType;
import LLD2.StockBrokerSystem.enums.TransactionType;
import LLD2.StockBrokerSystem.strategy.LimitOrderStrategy;
import LLD2.StockBrokerSystem.strategy.MarketOrderStrategy;

import java.util.UUID;

public class OrderBuilder {
    private User user;
    private Stock stock;
    private OrderType type;
    private TransactionType transactionType;
    private int quantity;
    private double price;

    public OrderBuilder forUser(User user){
        this.user = user;
        return this;
    }

    public OrderBuilder withStock(Stock stock){
        this.stock = stock;
        return this;
    }

    public OrderBuilder buy(int quantity)
    {
        this.transactionType = TransactionType.BUY;
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder sell(int quantity)
    {
        this.transactionType = TransactionType.SELL;
        this.quantity = quantity;
        return this;
    }

    public OrderBuilder atMaretPrice()
    {
        this.type = OrderType.MARKET;
        this.price = 0;
        return this;
    }

    public OrderBuilder withLimit(double limitPrice)
    {
        this.type = OrderType.LIMIT;
        this.price = limitPrice;
        return this;
    }

    public Order build()
    {
        return new Order(
                UUID.randomUUID().toString(),
                user,
                stock,
                type,
                quantity,
                price,
                type == OrderType.MARKET ? new MarketOrderStrategy() : new LimitOrderStrategy(transactionType),
                user
        );
    }
}
