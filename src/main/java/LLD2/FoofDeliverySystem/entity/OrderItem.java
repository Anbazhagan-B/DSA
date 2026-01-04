package LLD2.FoofDeliverySystem.entity;

import java.util.Map;

public class OrderItem {
    int quantity;
    MenuItem menuItem;

    public OrderItem(MenuItem menuItem, int quantity)
    {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public int getQuantity() {
        return quantity;
    }
}
