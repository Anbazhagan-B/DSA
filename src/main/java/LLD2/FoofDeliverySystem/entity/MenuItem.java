package LLD2.FoofDeliverySystem.entity;

public class MenuItem {
    String id;
    String name;
    double price;
    boolean isAvailable;

    public MenuItem(String id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isAvailable = true;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
