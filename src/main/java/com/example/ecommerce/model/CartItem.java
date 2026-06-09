package com.example.ecommerce.model;

/**
 * Represents a single item in a shopping cart.
 * ENCAPSULATION: quantity and product tightly controlled.
 */
public class CartItem {

    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be at least 1.");
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct()  { return product; }
    public int getQuantity()     { return quantity; }

    public void setQuantity(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be at least 1.");
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return product.getPrice() * quantity;
    }

    public double getDiscountedSubtotal() {
        // POLYMORPHISM: calls the correct applyDiscount() for each product type
        return product.applyDiscount() * quantity;
    }

    @Override
    public String toString() {
        return String.format("  %s x%d | Subtotal: R%.2f (Discounted: R%.2f)",
                product.getName(), quantity, getSubtotal(), getDiscountedSubtotal());
    }
}
