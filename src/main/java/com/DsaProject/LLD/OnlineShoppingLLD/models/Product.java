package com.DsaProject.LLD.OnlineShoppingLLD.models;

import com.DsaProject.LLD.OnlineShoppingLLD.enums.ProductCategory;

import java.util.UUID;

public abstract class Product {
    String id;
    String name;
    String description;
    double price;
    ProductCategory category;

    public abstract String getId();
    public abstract String getName();
    public abstract String getDescription();
    public abstract double getPrice();
    public abstract ProductCategory getCategory();

    public static class BaseProduct extends Product{
        private BaseProduct(String id, String name, String description, double price, ProductCategory category)
        {
            this.id = id;
            this.name = name;
            this.description = description;
            this.price = price;
            this.category = category;
        }

        @Override
        public String getId()
        {
            return this.id;
        }

        @Override
        public String getName() {
            return this.name;
        }

        @Override
        public String getDescription() {
            return this.description;
        }

        @Override
        public double getPrice() {
            return price;
        }

        @Override
        public ProductCategory getCategory() {
            return category;
        }
    }

    public static  class Builder{
        private final String name;
        private final double price;
        private String description = "";
        private ProductCategory category;

        public Builder(String name, double price)
        {
            this.name = name;
            this.price = price;
        }

        public Builder withDescription(String description) { this.description = description; return this; }
        public Builder withCategory(ProductCategory category) { this.category = category; return this; }
        public Product build() {
            return new BaseProduct(UUID.randomUUID().toString(), name, description, price, category);
        }
    }
}
