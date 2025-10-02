package com.DsaProject.LLD.FoodDeliveryServiceLLD.observer;

import com.DsaProject.LLD.FoodDeliveryServiceLLD.order.Order;

public interface OrderObserver {
    void onUpdate(Order order);
}
