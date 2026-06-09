package com.example.ecommerce.model;

/**
 * INHERITANCE: Clothing extends Product.
 * POLYMORPHISM: Different discount logic from Electronics.
 */
public class Clothing extends Product {

    private String size;
    private String colour;

    public Clothing(String productId, String name, double price, int stockQuantity,
                    String size, String colour) {
        super(productId, name, price, stockQuantity);
        this.size = size;
        this.colour = colour;
    }

    public String getSize()   { return size; }
    public String getColour() { return colour; }

    @Override
    public String getCategory() {
        return "Clothing";
    }

    @Override
    public double applyDiscount() {
        // Clothing gets a 20% discount
        return getPrice() * 0.80;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | Size: %s | Colour: %s", size, colour);
    }
}
