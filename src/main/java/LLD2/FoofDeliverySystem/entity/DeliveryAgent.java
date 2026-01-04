package LLD2.FoofDeliverySystem.entity;

import java.util.concurrent.atomic.AtomicBoolean;

public class DeliveryAgent extends User{

    AtomicBoolean isAvailable = new AtomicBoolean(false);
    Address currentLocation;
    public DeliveryAgent(String name, String phoneNumber, Address currentLocation)
    {
        super(name, phoneNumber);
        this.currentLocation = currentLocation;
    }

    public void setAvailable(boolean available) {
        this.isAvailable.set(available);
    }

    public synchronized boolean isAvailable() {
        return isAvailable.get();
    }

    public void setCurrentLocation(Address currentLocation) { this.currentLocation = currentLocation; }

    public Address getCurrentLocation() { return currentLocation; }

    @Override public void onUpdate(Order order) {
        System.out.printf("--- Notification for Delivery Agent %s ---\n", getName());
        System.out.printf("  Order %s update: Status is %s.\n", order.getId(), order.getOrderStatus());
        System.out.println("-------------------------------------------\n");
    }
}
