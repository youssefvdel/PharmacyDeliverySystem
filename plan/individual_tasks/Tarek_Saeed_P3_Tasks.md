# Tarek Saeed (252382) - Phase 3 Tasks
## Grade: A | Use Case: UC_02 Assign Courier

---

## Your Phase 2 Fixes

### Activity Diagram (Assign Courier)
Check if your diagram has:
- [ ] One consistent perspective (Actor-centric OR System-centric)
- [ ] Only ONE end node
- [ ] Join bars if parallel flows exist

### Sequence Diagram (Assign Courier)
Check if your diagram has:
- [ ] Title at top: `Sequence Diagram: Assign Courier`
- [ ] Activation bars on all lifelines
- [ ] Alt frames spanning all involved lifelines

---

## Your Code Task: UC_02 Assign Courier

### What to Build
Java desktop app for courier assignment:
- View pending orders list
- View available couriers
- Select order by priority/location
- Assign courier to order
- Update order status to "Dispatch"
- Notify courier

### Required Classes
```
Courier.java              (model)
CourierAssignment.java    (model)
CourierController.java    (controller)
CourierGUI.java           (Swing GUI)
DatabaseConnection.java   (Derby connection)
```

### Database Table: Courier
```sql
CREATE TABLE Courier (
    courierId INT PRIMARY KEY,
    name VARCHAR(100),
    phoneNumber VARCHAR(20),
    isAvailable BOOLEAN,
    currentLocation VARCHAR(100),
    deliveryArea VARCHAR(100)
);
```

### Database Table: Order (for assignment)
```sql
ALTER TABLE Order ADD COLUMN courierId INT;
ALTER TABLE Order ADD COLUMN status VARCHAR(50);
```

### Exception Handling Required
- Try/catch on ALL database operations
- Check if courier is available before assignment
- Handle assignment conflicts (courier already assigned)
- Show user-friendly error messages

### Screenshots Needed (3)
1. GUI showing pending orders + couriers
2. Success: Courier assigned successfully
3. Error: No couriers available or conflict

### Test Scenarios Required (2)
**NEW REQUIREMENT:** Write 2 test scenarios with reports:

**TC_01 - Happy Path:**
- Description: Assign available courier to pending order
- Pre-conditions: Order status is "Pending", courier is available
- Steps: 1) Select pending order 2) Select available courier 3) Click "Assign"
- Expected: "Courier assigned successfully", order status updates to "Dispatch"

**TC_02 - Error Path:**
- Description: Assign courier when no couriers available
- Pre-conditions: Order status is "Pending", no couriers available
- Steps: 1) Select pending order 2) Try to assign courier
- Expected: Error message "No couriers available"

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
- "How do you handle no available couriers?"
  → "System alerts admin and suggests waiting or outsourcing"
- "What happens if courier is offline?"
  → "System suggests next available courier"
- "Show me your exception handling"
  → Demo try/catch for assignment conflicts

---

## Checklist

| Task | Status | Deadline |
|------|--------|----------|
| Verify Activity Diagram fixes | ⬜ | Day 1 |
| Verify Sequence Diagram fixes | ⬜ | Day 1 |
| Implement Courier assignment code | ⬜ | Day 2 |
| Take 3 screenshots | ⬜ | Day 2 |
| Write 2 test scenarios + run them | ⬜ | Day 2 |
| Write report sections | ⬜ | Day 3 |
| Practice oral Q&A | ⬜ | Day 3 |

---

**Remember:**
- No AI for submission content → Rewrite in your own words
- Merge P1+P2+fixes+code into ONE PDF
- Oral = 25% of mark → Know your diagrams cold
