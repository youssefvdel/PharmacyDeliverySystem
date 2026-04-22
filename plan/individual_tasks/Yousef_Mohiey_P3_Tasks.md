# Yousef Mohiey (248679) - Phase 3 Tasks
## Grade: A | Use Case: UC_05 Manage Order

---

## Your Phase 2 Fixes

### Activity Diagram (Manage Order)
**Problem:** Missing join bar
**Fix:** Add **thick horizontal join bar** where parallel flows merge

**Also check:**
- [ ] One consistent perspective
- [ ] Only ONE end node

### Sequence Diagram (Manage Order)
**Problem:** Alt frame too narrow
**Fix:** Stretch `alt` frame to cover **ALL** involved lifelines

**Also check:**
- [ ] Title at top: `Sequence Diagram: Manage Order`
- [ ] Activation bars on all lifelines

---

## Your Code Task: UC_05 Manage Order

### What to Build
Java desktop app for order management:
- Place new order (select medicines, enter quantity)
- Modify existing order (if status is Pending)
- Cancel order (if status is Pending)
- Check stock availability
- Calculate total
- Process payment

### Required Classes
```
Order.java               (model)
OrderItem.java           (model)
OrderController.java     (controller)
OrderGUI.java            (Swing GUI)
DatabaseConnection.java  (Derby connection)
```

### Database Table: Order
```sql
CREATE TABLE Order (
    orderId INT PRIMARY KEY,
    customerId INT,
    status VARCHAR(50),
    totalAmount DOUBLE,
    deliveryAddress VARCHAR(255),
    orderDate DATE
);
```

### Database Table: OrderItem
```sql
CREATE TABLE OrderItem (
    itemId INT PRIMARY KEY,
    orderId INT,
    medicineId INT,
    quantity INT,
    price DOUBLE
);
```

### Exception Handling Required
- Try/catch on ALL database operations
- Validate stock before placing order
- Check order status before modify/cancel
- Validate payment
- Show user-friendly error messages

### Screenshots Needed (3)
1. GUI showing order placement form
2. Success: Order placed successfully
3. Error: Stock unavailable or payment failed

### Test Scenarios Required (2)
**NEW REQUIREMENT:** Write 2 test scenarios with reports:

**TC_01 - Happy Path:**
- Description: Place order with valid items and sufficient stock
- Pre-conditions: Customer logged in, medicines in stock
- Steps: 1) Select medicines and quantities 2) Enter delivery address 3) Click "Place Order"
- Expected: "Order placed successfully", status "Pending"

**TC_02 - Error Path:**
- Description: Place order with insufficient stock
- Pre-conditions: Customer logged in, medicine stock = 0
- Steps: 1) Select out-of-stock medicine 2) Click "Place Order"
- Expected: Error message "Stock not available"

---

## Report Sections You Write
1. Updated Activity Diagram description
2. Updated Sequence Diagram description
3. Code screenshots + descriptions
4. **Test scenarios + test reports** (NEW!)
5. Your contribution to Phase 3

---

## Oral Defense Prep
**Questions you will face:**
- "Why the join bar in Activity Diagram?"
  → "Fork/Join must balance; parallel flows must merge before continuing"
- "Why stretch alt over all lifelines?"
  → "Alt frames must span all participating objects per UML standard"
- "Show me your exception handling"
  → Demo try/catch for stock check and payment processing

---

## Checklist

| Task | Status | Deadline |
|------|--------|----------|
| Fix Activity Diagram join bar | ⬜ | Day 1 |
| Fix Sequence Diagram alt frame | ⬜ | Day 1 |
| Implement Order code | ⬜ | Day 2 |
| Take 3 screenshots | ⬜ | Day 2 |
| Write 2 test scenarios + run them | ⬜ | Day 2 |
| Write report sections | ⬜ | Day 3 |
| Practice oral Q&A | ⬜ | Day 3 |

---

**Remember:**
- No AI for submission content → Rewrite in your own words
- Merge P1+P2+fixes+code into ONE PDF
- Oral = 25% of mark → Know your diagrams cold
