package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ProductCatalogue service — manages the store's product inventory.
 * Demonstrates ENCAPSULATION: internal list is never exposed directly.
 * Demonstrates POLYMORPHISM: operates on Product references regardless of subtype.
 */
public class ProductCatalogue {

    private List<Product> products;

    public ProductCatalogue() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findById(String productId) {
        return products.stream()
                .filter(p -> p.getProductId().equals(productId))
                .findFirst()
                .orElse(null);
    }

    public List<Product> findByCategory(String category) {
        return products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<Product> getInStockProducts() {
        return products.stream()
                .filter(Product::isInStock)
                .collect(Collectors.toList());
    }

    public void printAllProducts() {
        System.out.println("\n===== PRODUCT CATALOGUE =====");
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        // POLYMORPHISM: toString() calls the correct subclass implementation
        products.forEach(p -> System.out.println(p));
        System.out.println("=============================\n");
    }

    public void printDiscountedPrices() {
        System.out.println("\n===== SALE PRICES =====");
        for (Product p : products) {
            // POLYMORPHISM: applyDiscount() behaves differently per subclass
            System.out.printf("%-30s Original: R%.2f  ->  Sale: R%.2f%n",
                    p.getName(), p.getPrice(), p.applyDiscount());
        }
        System.out.println("=======================\n");
    }
}
