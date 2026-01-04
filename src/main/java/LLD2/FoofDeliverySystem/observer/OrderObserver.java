package LLD2.FoofDeliverySystem.observer;

import LLD2.FoofDeliverySystem.entity.Order;

public interface OrderObserver {
    void onUpdate(Order order);
}
