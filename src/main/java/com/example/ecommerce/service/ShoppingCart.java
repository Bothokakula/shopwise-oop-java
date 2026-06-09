package com.example.ecommerce.service;

import com.example.ecommerce.model.CartItem;
import com.example.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart service demonstrating ENCAPSULATION of cart logic.
 * Cart state is private; all mutations go through controlled methods.
 */
public class ShoppingCart {

    private List<CartItem> items;
    private String customerId;

    public ShoppingCart(String customerId) {
        this.customerId = customerId;
        this.items = new ArrayList<>();
    }

    public String getCustomerId() { return customerId; }

    public void addItem(Product product, int quantity) {
        if (!product.isInStock()) {
            System.out.println("Sorry, " + product.getName() + " is out of stock.");
            return;
        }
        // Check if product already in cart
        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(product.getProductId())) {
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("Updated quantity for: " + product.getName());
                return;
            }
        }
        items.add(new CartItem(product, quantity));
        System.out.println("Added to cart: " + product.getName());
    }

    public void removeItem(String productId) {
        items.removeIf(item -> item.getProduct().getProductId().equals(productId));
        System.out.println("Removed item: " + productId);
    }

    public double getTotalPrice() {
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    public double getDiscountedTotal() {
        // POLYMORPHISM: each CartItem calls the correct product's applyDiscount()
        return items.stream().mapToDouble(CartItem::getDiscountedSubtotal).sum();
    }

    public double getSavings() {
        return getTotalPrice() - getDiscountedTotal();
    }

    public List<CartItem> getItems() { return items; }

    public boolean isEmpty() { return items.isEmpty(); }

    public void clearCart() { items.clear(); }

    public void printReceipt() {
        System.out.println("\n========================================");
        System.out.println("       SHOPWISE — ORDER RECEIPT");
        System.out.println("========================================");
        System.out.println("Customer ID: " + customerId);
        System.out.println("----------------------------------------");
        for (CartItem item : items) {
            System.out.println(item);
        }
        System.out.println("----------------------------------------");
        System.out.printf("Original Total:   R%.2f%n", getTotalPrice());
        System.out.printf("You Save:         R%.2f%n", getSavings());
        System.out.printf("Discounted Total: R%.2f%n", getDiscountedTotal());
        System.out.println("========================================\n");
    }
}
