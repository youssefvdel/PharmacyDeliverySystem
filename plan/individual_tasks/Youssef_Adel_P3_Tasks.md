# Youssef Adel (258270) - Phase 3 Tasks
## Grade: A | Use Case: UC_01 Manage Inventory

---

## Your Phase 2 Fixes

### Activity Diagram 4 (Manage Inventory)
**Problem:** Mixed perspectives (Admin + System swimlanes)
**Fix:** Pick **ONE** perspective
- Option A: Admin-centric - show what Admin does, system responses as actions
- Option B: System-centric - show system flow only
**Recommendation:** Use Admin-centric (actor actions on left, system on right)

**Also fix:** Multiple end nodes → reduce to ONE Activity Final Node

### Sequence Diagram (Manage Inventory)
**Problem:** None major (you got A)
**Minor fix:** Ensure title is at top: `Sequence Diagram: Manage Inventory`

### Class Diagram (Team Lead)
You must coordinate these 7 fixes:
1. Add FR methods to correct classes
2. Add relation names (`places`, `manages`, `assigns`)
3. Order→Payment = Composition (filled diamond)
4. Delete DeliveryAddress/OrderItem/TrackingInfo as classes
5. Add `Inventory` class
6. Add abstract `Staff` class
7. Remove all arrowheads

---

## Your Code Task: UC_01 Manage Inventory

### What to Build
Java desktop app for inventory management:
- View all medicines
- Search medicine by name/ID
- Update stock quantity
- Update price
- Add new medicine
- Delete medicine

### Required Classes
```
Inventory.java          (model)
InventoryController.java (controller)
InventoryGUI.java       (Swing GUI)
DatabaseConnection.java  (Derby connection)
```

### Database Table: Medicine
```sql
CREATE TABLE Medicine (
    medicineId INT PRIMARY KEY,
    name VARCHAR(100),
    category VARCHAR(50),
    price DOUBLE,
    stockQuantity INT,
    expiryDate DATE,
    description VARCHAR(255)
);
```

### Exception Handling Required
- Try/catch on ALL database operations
- Try/catch on user input validation
- Show user-friendly error messages (not stack traces)

### Screenshots Needed (3)
1. GUI showing inventory list
2. Success: Medicine updated successfully
3. Error: Invalid input or database error

### Test Scenarios Required (2)
**NEW REQUIREMENT:** Write 2 test scenarios with reports:

**TC_01 - Happy Path:**
- Description: Add new medicine with valid data
- Pre-conditions: Admin logged in, medicine does not exist
- Steps: 1) Click "Add Medicine" 2) Enter valid name, price, stock, expiry 3) Click Save
- Expected: "Medicine added successfully" message

**TC_02 - Error Path:**
- Description: Add medicine with invalid data (negative price)
- Pre-conditions: Admin logged in
- Steps: 1) Click "Add Medicine" 2) Enter negative price 3) Click Save
- Expected: Error message "Price must be positive"

---

## Report Sections You Write
1. Updated Activity Diagram 4 description
2. Class Diagram fixes documentation
3. Code screenshots + descriptions
4. **Test scenarios + test reports** (NEW!)
5. Your contribution to Phase 3

---

## Oral Defense Prep
**Questions you will face:**
- "Why did you choose Admin-centric perspective?"
  → "Admin is primary actor; system responds to admin actions"
- "How does Inventory class relate to Medicine?"
  → "Inventory tracks stock for each medicine; Medicine is the product info"
- "Show me your exception handling"
  → Demo try/catch around database operations

---

## Checklist

| Task | Status | Deadline |
|------|--------|----------|
| Fix Activity Diagram 4 perspective | ⬜ | Day 1 |
| Lead Class Diagram fixes | ⬜ | Day 1 |
| Fix Sequence Diagram title | ⬜ | Day 1 |
| Implement Inventory code | ⬜ | Day 2 |
| Take 3 screenshots | ⬜ | Day 2 |
| Write 2 test scenarios + run them | ⬜ | Day 2 |
| Write report sections | ⬜ | Day 3 |
| Practice oral Q&A | ⬜ | Day 3 |

---

**Remember:**
- No AI for submission content → Rewrite in your own words
- Merge P1+P2+fixes+code into ONE PDF
- Oral = 25% of mark → Know your diagrams cold
