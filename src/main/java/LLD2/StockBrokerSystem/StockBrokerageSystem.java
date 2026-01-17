package LLD2.StockBrokerSystem;

import LLD2.StockBrokerSystem.command.BuyStockCommand;
import LLD2.StockBrokerSystem.command.OrderCommand;
import LLD2.StockBrokerSystem.command.SellStockCommand;
import LLD2.StockBrokerSystem.entities.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StockBrokerageSystem {
    private static volatile StockBrokerageSystem instance;
    final Map<String, User> users;
    final Map<String, Stock> stocks;

    private StockBrokerageSystem()
    {
        this.users = new ConcurrentHashMap<>();
        this.stocks = new ConcurrentHashMap<>();
    }

    public static StockBrokerageSystem getInstance() {
        if(instance == null)
        {
            synchronized (StockBrokerageSystem.class)
            {
                if(instance == null)
                {
                    instance = new StockBrokerageSystem();
                }
            }
        }
        return instance;
    }

    public User registerUser(String name, double initialAMount)
    {
        User user  = new User(name, initialAMount);
        users.put(user.getUserId(), user);
        return user;
    }

    public Stock addStock(String symbol, double initialPrice)
    {
        Stock stock = new Stock(symbol, initialPrice);
        stocks.put(stock.getSymbol(), stock);
        return stock;
    }
    public void placeBuyOrder(Order order) {
        User user = order.getUser();
        OrderCommand command = new BuyStockCommand(user.getAccount(), order);
        command.execute();
    }

    public void placeSellOrder(Order order) {
        User user = order.getUser();
        OrderCommand command = new SellStockCommand(user.getAccount(), order);
        command.execute();
    }

    public void cancelOrder(Order order) {
        order.cancel();
    }
}
