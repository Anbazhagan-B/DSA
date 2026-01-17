package LLD2.StockBrokerSystem.entities;

import LLD2.StockBrokerSystem.observer.StockObserver;

import java.util.*;

public class Stock {
    final String symbol;
    double price;
    final List<StockObserver> observers = new ArrayList<>();

    public Stock(String symbol, double initialPrice)
    {
        this.symbol = symbol;
        this.price = initialPrice;
    }

    public double getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setPrice(double newPrice) {
        if(this.price != newPrice)
        {
            this.price = newPrice;
            notifyObservers();
        }
        this.price = price;
    }

    public void addObserver(StockObserver observer)
    {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer)
    {
        observers.remove(observer);
    }

    private void notifyObservers()
    {
        for(StockObserver observer : observers)
        {
            observer.update(this);
        }
    }
}
