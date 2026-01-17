package LLD2.StockBrokerSystem.observer;

import LLD2.StockBrokerSystem.entities.Stock;

public interface StockObserver {
    void update(Stock stock);
}
