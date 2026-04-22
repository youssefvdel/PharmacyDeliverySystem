# Yousif Hafez (258612) - Phase 3 Tasks
## Grade: A | Use Case: UC_04 Track Order

---

## Your Phase 2 Fixes

### Activity Diagram (Track Order)
**Problem:** Multiple end nodes
**Fix:** Reduce to **ONE** Activity Final Node

**Also check:**
- [ ] One consistent perspective
- [ ] Join bars if parallel flows exist

### Sequence Diagram (Track Order)
**Problem:** Customer missing activation bar
**Fix:** Add thin vertical rectangle on Customer lifeline during interaction

**Also check:**
- [ ] Title at top: `Sequence Diagram: Track Order Status`
- [ ] Alt frames spanning all lifelines

---

## Your Code Task: UC_04 Track Order

### What to Build
Java desktop app for order tracking:
- Enter order ID
- Retrieve order from database
- Display current status (Pending, Processing, Out for Delivery, Delivered)
- Show order details (items, delivery address, estimated time)
- Handle invalid order IDs

### Required Classes
```
Order.java               (model)
TrackingInfo.java        (model)
OrderController.java     (controller)
TrackingGUI.java         (Swing GUI)
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
    orderDate DATE,
    courierId INT
);
```

### Exception Handling Required
- Try/catch on ALL database operations
- Validate order ID exists
- Handle database connection failures
- Show user-friendly error messages

### Screenshots Needed (3)
1. GUI showing order search form
2. Success: Order status displayed
3. Error: Order not found or connection failed

### Test Scenarios Required (2)
**NEW REQUIREMENT:** Write 2 test scenarios with reports:

**TC_01 - Happy Path:**
- Description: Track existing order with valid ID
- Pre-conditions: Order exists in database
- Steps: 1) Enter valid order ID 2) Click "Track"
- Expected: Order status and details displayed

**TC_02 - Error Path:**
- Description: Track order with invalid ID
- Pre-conditions: None
- Steps: 1) Enter non-existent order ID "99999" 2) Click "Track"
- Expected: Error message "Order not found"

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
- "Why only one end node in Activity Diagram?"
  → "Lab requirement: Activity diagrams must have exactly one final node"
- "Why add activation bar on Customer?"
  → "Actors get activation bars during interaction per UML standard"
- "Show me your exception handling"
  → Demo try/catch for invalid order ID

---

## Checklist

| Task | Status | Deadline |
|------|--------|----------|
| Fix Activity Diagram end nodes | ⬜ | Day 1 |
| Fix Sequence Diagram activation bar | ⬜ | Day 1 |
| Implement Track Order code | ⬜ | Day 2 |
| Take 3 screenshots | ⬜ | Day 2 |
| Write 2 test scenarios + run them | ⬜ | Day 2 |
| Write report sections | ⬜ | Day 3 |
| Practice oral Q&A | ⬜ | Day 3 |

---

**Remember:**
- No AI for submission content → Rewrite in your own words
- Merge P1+P2+fixes+code into ONE PDF
- Oral = 25% of mark → Know your diagrams cold
