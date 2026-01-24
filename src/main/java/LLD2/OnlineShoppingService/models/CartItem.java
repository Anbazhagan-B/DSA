package LLD2.OnlineShoppingService.models;

public class CartItem {
    final Product product;
    int quantity;

    public CartItem(Product product, int quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct()
    {
        return product;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void incrementQuantity(int amount) {this.quantity += amount; }

    public double getPrice(){
        return product.getPrice() * quantity;
    }
}
