# 🛒 ShopWise — Java OOP E-Commerce Demo

A Java console application demonstrating core Object-Oriented Programming principles through a simulated e-commerce system. Built as a portfolio project to showcase clean, maintainable, and scalable software design.

---

## 🎯 OOP Concepts Demonstrated

### 1. Encapsulation
All fields in `Product`, `CartItem`, and `ShoppingCart` are **private**. Access is controlled through getters and setters that enforce business rules (e.g. price cannot be negative, stock cannot go below zero).

```java
public void setPrice(double price) {
    if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
    this.price = price;
}
```

### 2. Inheritance
`Electronics`, `Clothing`, and `Food` all **extend** the abstract `Product` class. They inherit shared behaviour (stock management, toString base) and add their own fields.

```
Product (abstract)
├── Electronics  (brand, warrantyMonths)
├── Clothing     (size, colour)
└── Food         (expiryDate, isOrganic)
```

### 3. Polymorphism
Each subclass **overrides** `applyDiscount()` and `getCategory()` with its own logic:

| Product Type | Discount |
|---|---|
| Electronics | 10% off |
| Clothing | 20% off |
| Food (Organic) | 5% off |
| Food (Regular) | 15% off |

The `ShoppingCart` calls `applyDiscount()` on a `Product` reference — the correct subclass method runs automatically.

### 4. Abstraction
`Product` is an **abstract class**. It defines the contract (`getCategory()`, `applyDiscount()`) but leaves the implementation to each subclass.

---

## 📂 Project Structure

```
src/
└── main/java/com/example/ecommerce/
    ├── Main.java                        # Entry point
    ├── model/
    │   ├── Product.java                 # Abstract base class
    │   ├── Electronics.java             # Inherits Product
    │   ├── Clothing.java                # Inherits Product
    │   ├── Food.java                    # Inherits Product
    │   ├── CartItem.java                # Encapsulates cart line item
    │   └── Discountable.java            # Interface (polymorphism)
    └── service/
        ├── ProductCatalogue.java        # Manages product inventory
        └── ShoppingCart.java            # Manages cart operations
```

---

## 🚀 Getting Started

### Prerequisites
- Java 11 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code with Java extension)

### Run the project

1. Clone the repository:
   ```bash
   git clone https://github.com/Bothokakula/shopwise-oop-java.git
   ```

2. Open in your IDE and run `Main.java`, or compile via terminal:
   ```bash
   cd src/main/java
   javac com/example/ecommerce/**/*.java com/example/ecommerce/Main.java
   java com.example.ecommerce.Main
   ```

---

## 🧾 Sample Output

```
===== PRODUCT CATALOGUE =====
[E001] Samsung Galaxy Book | Category: Electronics | Price: R15999.99 | Stock: 10 | Brand: Samsung | Warranty: 24 months
[C001] Levi's Denim Jacket | Category: Clothing | Price: R1299.99 | Stock: 50 | Size: L | Colour: Indigo Blue
...

===== SALE PRICES =====
Samsung Galaxy Book          Original: R15999.99  ->  Sale: R14399.99
Levi's Denim Jacket          Original: R1299.99   ->  Sale: R1039.99
...

========================================
       SHOPWISE — ORDER RECEIPT
========================================
Customer ID: CUST-001
...
Discounted Total: R16842.45
========================================
```

---

## 🛠️ Tech Stack

| | |
|---|---|
| Language | Java 11+ |
| Paradigm | Object-Oriented Programming |
| IDE | IntelliJ IDEA / VS Code |

---

