# Yosef Gad (255796) - Phase 3 Tasks
## Grade: B | Use Case: UC_03 Manage Profile

---

## Your Phase 2 Fixes (PRIORITY - You got B)

### Activity Diagram (Manage Profile)
**Problem:** Mixed perspectives (Customer + System)
**Fix:** Pick **ONE** perspective
- Option A: Customer-centric
- Option B: System-centric
**Recommendation:** Use Customer-centric

**Also check:**
- [ ] Only ONE end node
- [ ] Join bars if parallel flows exist

### Sequence Diagram (Manage Profile)
**Check:**
- [ ] Title at top: `Sequence Diagram: Manage Profile`
- [ ] Activation bars on all lifelines (including Customer actor)
- [ ] Alt frames spanning all lifelines

---

## Your Code Task: UC_03 Manage Profile

### What to Build
Java desktop app for customer profile management:
- View profile data
- Update personal info (name, phone, email)
- Update delivery address
- Update payment methods
- Validate input before saving

### Required Classes
```
Customer.java            (model)
CustomerController.java  (controller)
ProfileGUI.java          (Swing GUI)
DatabaseConnection.java  (Derby connection)
```

### Database Table: Customer
```sql
CREATE TABLE Customer (
    customerId INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    phone VARCHAR(20),
    address VARCHAR(255)
);
```

### Exception Handling Required
- Try/catch on ALL database operations
- Validate email format
- Validate phone format
- Check for empty fields
- Show user-friendly error messages

### Screenshots Needed (3)
1. GUI showing profile form
2. Success: Profile updated successfully
3. Error: Invalid email or database error

### Test Scenarios Required (2)
**NEW REQUIREMENT:** Write 2 test scenarios with reports:

**TC_01 - Happy Path:**
- Description: Update profile with valid data
- Pre-conditions: Customer logged in
- Steps: 1) Open "Manage Profile" 2) Update name and phone 3) Click "Save"
- Expected: "Profile updated successfully" message

**TC_02 - Error Path:**
- Description: Update profile with invalid email format
- Pre-conditions: Customer logged in
- Steps: 1) Open "Manage Profile" 2) Enter invalid email "test@" 3) Click "Save"
- Expected: Error message "Invalid email format"

---

## Report Sections You Write
1. Updated Activity Diagram description (explain perspective fix)
2. Updated Sequence Diagram description
3. Code screenshots + descriptions
4. **Test scenarios + test reports** (NEW!)
5. Your contribution to Phase 3

---

## Oral Defense Prep
**Questions you will face:**
- "Why did you get a B in Phase 2?"
  → "Mixed perspectives in Activity Diagram; fixed by choosing one viewpoint"
- "How do you validate user input?"
  → "Check email format, phone format, non-empty fields before DB update"
- "Show me your exception handling"
  → Demo try/catch for database save operations

---

## Checklist

| Task | Status | Deadline |
|------|--------|----------|
| Fix Activity Diagram perspective | ⬜ | Day 1 |
| Fix Sequence Diagram issues | ⬜ | Day 1 |
| Implement Profile code | ⬜ | Day 2 |
| Take 3 screenshots | ⬜ | Day 2 |
| Write 2 test scenarios + run them | ⬜ | Day 2 |
| Write report sections | ⬜ | Day 3 |
| Practice oral Q&A | ⬜ | Day 3 |

---

**Remember:**
- No AI for submission content → Rewrite in your own words
- Merge P1+P2+fixes+code into ONE PDF
- Oral = 25% of mark → Know your diagrams cold
- **You need to upgrade from B to A** → Pay extra attention to fixes
