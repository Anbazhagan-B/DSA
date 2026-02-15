package LLD2.OnlineShoppingService.observer;

import LLD2.OnlineShoppingService.models.Order;

public interface OrderObserver {
    void update(Order order);
}
