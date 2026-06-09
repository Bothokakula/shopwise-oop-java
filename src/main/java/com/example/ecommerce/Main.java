package com.example.ecommerce;

import com.example.ecommerce.model.*;
import com.example.ecommerce.service.ProductCatalogue;
import com.example.ecommerce.service.ShoppingCart;

/**
 * Main entry point for the ShopWise E-Commerce OOP Demo.
 *
 * OOP Concepts demonstrated:
 *  - ENCAPSULATION: Private fields with controlled getters/setters in Product, CartItem, ShoppingCart
 *  - INHERITANCE:   Electronics, Clothing, Food all extend the abstract Product class
 *  - POLYMORPHISM:  applyDiscount(), getCategory(), toString() behave differently per subclass
 *  - ABSTRACTION:   Product is abstract; concrete behaviour defined in subclasses
 */
public class Main {

    public static void main(String[] args) {

        // --- 1. SET UP PRODUCT CATALOGUE ---
        ProductCatalogue catalogue = new ProductCatalogue();

        // INHERITANCE: Each subclass calls super() and adds its own fields
        Electronics laptop = new Electronics("E001", "Samsung Galaxy Book", 15999.99, 10, "Samsung", 24);
        Electronics headphones = new Electronics("E002", "Sony WH-1000XM5", 4999.99, 25, "Sony", 12);
        Clothing jacket = new Clothing("C001", "Levi's Denim Jacket", 1299.99, 50, "L", "Indigo Blue");
        Clothing sneakers = new Clothing("C002", "Nike Air Max 90", 2199.99, 30, "10", "White/Black");
        Food oats = new Food("F001", "Woolworths Rolled Oats", 89.99, 100, "2026-12-01", true);
        Food chips = new Food("F002", "Simba Chips Variety Pack", 49.99, 200, "2026-08-15", false);

        catalogue.addProduct(laptop);
        catalogue.addProduct(headphones);
        catalogue.addProduct(jacket);
        catalogue.addProduct(sneakers);
        catalogue.addProduct(oats);
        catalogue.addProduct(chips);

        // --- 2. DISPLAY CATALOGUE ---
        catalogue.printAllProducts();

        // --- 3. SHOW POLYMORPHIC DISCOUNT BEHAVIOUR ---
        // Each product type applies a different discount rate
        catalogue.printDiscountedPrices();

        // --- 4. SIMULATE SHOPPING CART ---
        ShoppingCart cart = new ShoppingCart("CUST-001");

        cart.addItem(laptop, 1);
        cart.addItem(jacket, 2);
        cart.addItem(oats, 3);
        cart.addItem(chips, 1);

        // POLYMORPHISM: getDiscountedSubtotal() calls the correct applyDiscount() per product type
        cart.printReceipt();

        // --- 5. DEMONSTRATE ENCAPSULATION VALIDATION ---
        System.out.println("--- Encapsulation Validation ---");
        try {
            laptop.setPrice(-500); // Should throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            jacket.setStockQuantity(-10); // Should throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        // --- 6. DEMONSTRATE INHERITANCE ---
        System.out.println("\n--- Inheritance Demo ---");
        System.out.println("Laptop brand (Electronics-specific): " + laptop.getBrand());
        System.out.println("Jacket size (Clothing-specific): " + jacket.getSize());
        System.out.println("Oats organic? (Food-specific): " + oats.isOrganic());

        // --- 7. POLYMORPHISM VIA PARENT REFERENCE ---
        System.out.println("\n--- Polymorphism via Parent Reference ---");
        Product[] products = { laptop, jacket, oats };
        for (Product p : products) {
            // Same method call, different behaviour per subclass
            System.out.printf("%-35s -> Discounted: R%.2f%n", p.getName(), p.applyDiscount());
        }
    }
}
