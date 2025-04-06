# TEST CASES

This file contains test cases to verify the core functionalities of the E-commerce-like application using Java + Hibernate.

---

## Test Case 1: Create a New User

**Description**: Add a new user to the system.

- **Input**:
  - `username`: testuser
  - `password`: testpass123
  - `email`: test@example.com
  - `role`: CUSTOMER

- **Expected Output**:
  - User is successfully inserted into the database.
  - The user has a unique ID generated.
  - Password is stored in hashed format using BCrypt.

---

## 🧪 Test Case 2: Insert a New Product

**Description**: Add a product to the inventory.

- **Input**:
  - `name`: Wireless Mouse
  - `stockQuantity`: 50
  - `price`: 799.99

- **Expected Output**:
  - Product is added with a unique ID.
  - Available in stock for future orders.

---
## Test Case 3: Place an Order for an Existing User

**Objective:**  
Confirm that an order and its associated order details are properly saved and the product stock updates correctly.

---

- **Input**:

- **User (must already exist):**  
  - `id`: 1

- **Product (must already exist):**  
  - `id`: 1  
  - `price`: ₹500 (example value)  
  - `stockQuantity`: 10 (example value before placing order)

- **Quantity to Order:**  
  - `2`

---

- **Expected Output**:

- A new entry in the **`orders`** table:  
  - `userId`: 1  
  - `totalAmount`: ₹1000 (`₹500 * 2`)  
  - `orderDate`: Current timestamp