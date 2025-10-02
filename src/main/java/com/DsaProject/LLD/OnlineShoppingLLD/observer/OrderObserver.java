package com.DsaProject.LLD.OnlineShoppingLLD.observer;

import com.DsaProject.LLD.OnlineShoppingLLD.models.Order;

public interface OrderObserver {
    void update(Order order);
}
