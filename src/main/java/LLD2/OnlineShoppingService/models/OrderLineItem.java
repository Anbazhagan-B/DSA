package LLD2.OnlineShoppingService.models;

public class OrderLineItem {
    final String productId;
    final String productName;
    final int quantity;
    final double priceAtPurchase;

    public OrderLineItem(String productId, String productName, int quantity, double priceAtPurchase)
    {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.priceAtPurchase = priceAtPurchase;
    }

    public String getProductId() {return productId; }
    public int getQuantity() {return quantity; }
}
