package com.DsaProject.LLD.OnlineShoppingLLD.models;

public class Account {
    String username;
    String password;
    ShoppingCart cart;

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
