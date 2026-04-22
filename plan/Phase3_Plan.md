# Phase 3 Plan - Pharmacy Delivery System
## Group 39 | Deadline: Friday 24/4/2026

---

## Phase 3 Deliverables (From Email + E-Learning Template)

### 1. Final Project Report (ONE PDF)
Must contain **Phase 1 + Phase 2 updated according to feedback**. Not updating previous phases will lower your grade.

**Report Structure:**
1. **Amended System Description** (from Phase 1, updated if needed)
2. **Functional & Non-Functional Requirements** (from Phase 1)
3. **Analysis & Design Diagrams:**
   - Context Diagram
   - Use Case Diagram
   - **Class Diagram** (updated with 7 fixes from feedback)
   - **Sequence Diagrams** (updated with 3 fixes from feedback)
   - **Database Schema Diagrams** (NEW - ERD visual, not just SQL)
4. **Project Code + Screenshots** (desktop application GUI running)
5. **Two Test Scenarios + Test Reports** (NEW!)
6. **Contribution Table**

### 2. Project Code (ZIP)
- Desktop application with GUI (Java Swing/JavaFX)
- Each member implements **one functionality** from Phase 1 (excluding signup/login)
- **Exception handling** (try/catch) on all risky operations
- **Derby database** integration (see Week 11 lab)
- Screenshots of GUI running

### 3. Oral Discussion
- Week 13 (schedule attached to email)
- Be ready to explain your diagrams and code

---

## Critical Fixes from Phase 2 Feedback

### Class Diagram (7 Fixes - All Team)
| # | Feedback | Fix |
|---|----------|-----|
| 1 | FRs not in class diagram | Add methods: `Customer.processOrder()`, `Inventory.manageInventory()` |
| 2 | Missing relation names | Add labels: `places`, `manages`, `assigns` |
| 3 | Order-Payment relationship | Change to **Composition** (filled diamond on Order) |
| 4 | DeliveryAddress/OrderItem/TrackingInfo | Delete as classes → make `Order` attributes |
| 5 | Missing Inventory class | Add with `stockLevel`, `price`, `expiryDate` |
| 6 | Missing Staff class | Add abstract `Staff` → `Admin`/`Courier` inherit |
| 7 | Arrow shapes/direction | Remove all arrowheads → plain lines with multiplicity |

### Activity Diagrams (4 Fixes)
| Member | Issue | Fix |
|--------|-------|-----|
| Yosef Gad | Mixed perspectives | Pick ONE: Customer OR System viewpoint |
| Yousef Mohiey | Missing join bar | Add thick horizontal join where parallel flows merge |
| Yousif Hafez | Multiple end nodes | Reduce to **ONE** Activity Final Node |
| Youssef Adel | Mixed perspectives | Pick ONE: Admin OR System viewpoint |

### Sequence Diagrams (3 Fixes)
| Issue | Fix |
|-------|-----|
| Missing functionality names | Add header: `Sequence Diagram: [Use Case Title]` |
| Mohiey: alt too narrow | Stretch alt to cover ALL lifelines |
| Hafez: Customer missing bar | Add activation bar on Customer lifeline |

---

## 3-Day Execution Plan

### Day 1 (22/4) - Diagram Fixes
**Morning (2h):** Fix Class Diagram (all 7 items)
**Afternoon (2h):** Fix individual Activity + Sequence Diagrams
**Evening (1h):** Export all diagrams as high-res PNG

### Day 2 (23/4) - Code + DB + Test Scenarios
**Morning (3h):** Implement core classes + Derby schema
**Afternoon (3h):** Build GUIs for each functionality
**Evening (2h):** Write **2 Test Scenarios** + take screenshots

### Day 3 (24/4) - Merge + Submit
**Morning (3h):** Merge P1+P2+fixes+DB+code+tests into ONE document
**Afternoon (2h):** Proofread, format, export PDF
**Evening:** Submit BEFORE deadline

---

## Code Requirements

### Each Member Must Implement:
1. **GUI** for your assigned use case
2. **Database operations** (CRUD) using Derby
3. **Exception handling** (try/catch on ALL DB + input ops)
4. **Comments** (class header, method Javadoc)
5. **3 screenshots:** input, success, error handling

### Code Standards:
- Java Swing for GUI
- Apache Derby embedded database
- JDBC for database operations
- Prepared statements (prevent SQL injection)
- Close connections in finally block

### Functionalities by Member:
| Member | Use Case | Functionality |
|--------|----------|--------------|
| Youssef Adel | UC_01 | Manage Inventory (stock update, add medicine) |
| Tarek Saeed | UC_02 | Assign Courier to orders |
| Yosef Gad | UC_03 | Manage Customer Profile |
| Yousif Hafez | UC_04 | Track Order Status |
| Yousef Mohiey | UC_05 | Place/Manage Orders |

---

## Database Schema (Required)

### Visual ERD Diagram
**NEW REQUIREMENT:** You need a visual Entity Relationship Diagram showing:
- All tables
- Primary keys (PK)
- Foreign keys (FK)
- Relationships between tables
- Cardinality (1:1, 1:N, N:M)

### Tables needed:
- Customer (customerId, name, email, password, phone, address)
- Medicine (medicineId, name, category, price, stock, expiryDate)
- Inventory (inventoryId, medicineId, stockLevel, price, expiryDate)
- Order (orderId, customerId, status, totalAmount, deliveryAddress, orderDate)
- OrderItem (itemId, orderId, medicineId, quantity, price)
- Payment (paymentId, orderId, amount, method, status)
- Courier (courierId, name, phone, isAvailable, currentLocation)
- Staff (staffId, name, email, password, role) - abstract
- Admin (adminId) extends Staff

---

## Test Scenarios (NEW REQUIREMENT!)

### What to Include:
**Two Test Scenarios** with full test reports:

#### Test Scenario Template:
```
Test ID: TC_01
Description: [What is being tested]
Pre-conditions: [What must be true before test]
Steps:
  1. [Step 1]
  2. [Step 2]
  ...
Expected Result: [What should happen]
Actual Result: [What actually happened]
Status: [Pass / Fail]
```

### Test Scenarios to Write:
| Test | Type | Example |
|------|------|---------|
| TC_01 | Happy Path | Place order successfully with valid data |
| TC_02 | Error Path | Place order with invalid data (empty fields, invalid ID) |

### Each Member Must Write:
- 2 test scenarios for YOUR functionality
- Run the tests and document actual results
- Include screenshots of test execution

---

## Submission Checklist

**Report (PDF):**
- [ ] Amended system description
- [ ] Functional & non-functional requirements
- [ ] Phase 1 diagrams (Context, Use Case)
- [ ] Phase 2 diagrams updated with all 14 fixes (Class, Sequence)
- [ ] **Database Schema Diagrams** (visual ERD)
- [ ] Database DDL script
- [ ] **5 code screenshots** with descriptions
- [ ] **Two test scenarios + test reports** (NEW!)
- [ ] Contribution table
- [ ] File size < 10MB

**Code (ZIP):**
- [ ] All 5 functionalities implemented
- [ ] Exception handling everywhere
- [ ] Derby schema matches Class Diagram
- [ ] Buildable with README instructions
- [ ] No hardcoded paths

**Oral Prep:**
- [ ] Can explain your diagrams
- [ ] Can demo your code
- [ ] Know why you made design decisions

---

## Resources
- Week 11 lab PDFs (Derby integration guide)
- E-learning: "Exercise-20230403" project (Derby example)
- Phase 2 feedback PDF (what to fix)

---

*Plan based on Phase 3 email + E-learning template + TA feedback | Updated: April 2026*
