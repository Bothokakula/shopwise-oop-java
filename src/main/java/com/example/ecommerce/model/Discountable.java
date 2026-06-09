package com.example.ecommerce.model;

/**
 * Interface demonstrating POLYMORPHISM through interface contracts.
 * Any class implementing Discountable must define how promotions are applied.
 */
public interface Discountable {
    double applyPromoCode(String promoCode);
    boolean isEligibleForPromo();
}
