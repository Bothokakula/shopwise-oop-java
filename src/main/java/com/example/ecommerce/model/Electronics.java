package com.example.ecommerce.model;

/**
 * INHERITANCE: Electronics extends Product, inheriting all base behaviour.
 * POLYMORPHISM: Overrides getCategory() and applyDiscount() with its own logic.
 */
public class Electronics extends Product {

    private String brand;
    private int warrantyMonths;

    public Electronics(String productId, String name, double price, int stockQuantity,
                       String brand, int warrantyMonths) {
        super(productId, name, price, stockQuantity); // Call parent constructor
        this.brand = brand;
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand()        { return brand; }
    public int getWarrantyMonths()  { return warrantyMonths; }

    // POLYMORPHISM: own implementation of abstract methods
    @Override
    public String getCategory() {
        return "Electronics";
    }

    @Override
    public double applyDiscount() {
        // Electronics get a 10% discount
        return getPrice() * 0.90;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Brand: %s | Warranty: %d months",
                brand, warrantyMonths);
    }
}
