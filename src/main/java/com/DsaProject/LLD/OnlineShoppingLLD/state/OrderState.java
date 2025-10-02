package com.DsaProject.LLD.OnlineShoppingLLD.state;

import com.DsaProject.LLD.OnlineShoppingLLD.models.Order;

public interface OrderState {
    void ship(Order order);
    void deliver(Order order);
    void cancel(Order order);
}
