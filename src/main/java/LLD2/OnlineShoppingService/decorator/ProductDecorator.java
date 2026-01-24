package LLD2.OnlineShoppingService.decorator;

import LLD2.OnlineShoppingService.enums.ProductCategory;
import LLD2.OnlineShoppingService.models.Product;

public abstract class ProductDecorator extends Product {

    protected Product decoratedProduct;

    public ProductDecorator(Product product)
    {
        this.decoratedProduct = product;
    }

    @Override
    public String getId() {
        return this.decoratedProduct.getId();
    }

    @Override
    public String getName() {
        return this.decoratedProduct.getName();
    }

    @Override
    public String getDescription() {
        return this.decoratedProduct.getDescription();
    }

    @Override
    public double getPrice() {
        return this.decoratedProduct.getPrice();
    }

    @Override
    public ProductCategory getCategory() {
        return this.decoratedProduct.getCategory();
    }
}
