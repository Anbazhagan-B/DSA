package LLD2.OnlineShoppingService.models;


import com.DsaProject.LLD.OnlineShoppingLLD.models.ShoppingCart;

public class Account {
    final String username;
    final String password;
    final ShoppingCart cart;

    public Account(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.cart = new ShoppingCart();
    }

    public ShoppingCart getCart()
    {
        return cart;
    }
}
