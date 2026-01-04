package LLD2.FoofDeliverySystem.entity;

import java.util.*;

public class Customer extends User {
    Address address;
    List<Order> orderHistory;
    public Customer(String name, String phoneNumber, Address address)
    {
        super(name, phoneNumber);
        this.address = address;
        this.orderHistory = new ArrayList<>();
    }

    @Override
    public void onUpdate(Order order) {

    }
}
