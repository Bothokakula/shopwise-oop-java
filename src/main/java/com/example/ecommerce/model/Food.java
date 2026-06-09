package com.example.ecommerce.model;

/**
 * INHERITANCE: Food extends Product.
 * POLYMORPHISM: Food has expiry-based discount logic.
 */
public class Food extends Product {

    private String expiryDate;
    private boolean isOrganic;

    public Food(String productId, String name, double price, int stockQuantity,
                String expiryDate, boolean isOrganic) {
        super(productId, name, price, stockQuantity);
        this.expiryDate = expiryDate;
        this.isOrganic = isOrganic;
    }

    public String getExpiryDate() { return expiryDate; }
    public boolean isOrganic()    { return isOrganic; }

    @Override
    public String getCategory() {
        return "Food";
    }

    @Override
    public double applyDiscount() {
        // Organic food gets 5% discount; regular food gets 15%
        return isOrganic ? getPrice() * 0.95 : getPrice() * 0.85;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Expiry: %s | Organic: %s",
                expiryDate, isOrganic ? "Yes" : "No");
    }
}
