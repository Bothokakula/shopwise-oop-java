package com.example.ecommerce.model;

/**
 * Abstract base class demonstrating ENCAPSULATION and ABSTRACTION.
 * All fields are private and accessed via getters/setters.
 * Subclasses must implement getCategory() and applyDiscount() — POLYMORPHISM.
 */
public abstract class Product {

    // ENCAPSULATION: private fields, controlled access via getters/setters
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        setPrice(price);          // Use setter for validation
        setStockQuantity(stockQuantity);
    }

    // Getters
    public String getProductId()    { return productId; }
    public String getName()         { return name; }
    public double getPrice()        { return price; }
    public int getStockQuantity()   { return stockQuantity; }

    // Setters with validation (encapsulation: enforce business rules)
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        if (stockQuantity < 0) throw new IllegalArgumentException("Stock cannot be negative.");
        this.stockQuantity = stockQuantity;
    }

    public void setName(String name) { this.name = name; }

    // ABSTRACTION: subclasses define their own category and discount logic
    public abstract String getCategory();
    public abstract double applyDiscount();

    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public void reduceStock(int quantity) {
        if (quantity > stockQuantity)
            throw new IllegalStateException("Insufficient stock for: " + name);
        this.stockQuantity -= quantity;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s | Category: %s | Price: R%.2f | Stock: %d",
                productId, name, getCategory(), price, stockQuantity);
    }
}
