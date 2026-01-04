package LLD2.VendingMachine.entity;

public class Item {
    String name;
    String code;
    int price;

    public Item(String name, String code, int price)
    {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
