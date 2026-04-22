# 🎯 Tarek Saeed (252382) - Phase 3 Individual Tasks
**Grade:** A | **Focus:** DB Schema + Code Integration

---

## 🔧 YOUR SPECIFIC PHASE 2 FIXES

### Class Diagram (Team Task - You Own DB Mapping)
| # | Fix | Your Action |
|---|-----|-------------|
| 1 | FRs as methods in correct classes | Ensure `assignCourierToOrder()` method exists in `Administrator` class |
| 2 | Missing relation names | Add `assigns` label on Admin→Courier association |
| 3 | Order ↔ Payment composition | Verify filled diamond on Order side in your diagram section |
| 4 | Remove extra classes | Confirm `DeliveryAddress` is now attribute, not class |
| 5 | Add `Inventory` class | Map to database table structure |
| 6 | Add `Staff` abstract class | Document inheritance in DB schema (single table or joined) |
| 7 | Remove arrow shapes | Use plain lines in your diagram exports |

### DB Schema Design (Your Lead)
| Table | Key Columns | Relations |
|-------|------------|-----------|
| `orders` | order_id (PK), customer_id (FK), status, total | FK → customers, payments |
| `payments` | payment_id (PK), order_id (FK), amount, method | FK → orders (**ON DELETE CASCADE** for composition) |
| `inventory` | inventory_id (PK), medicine_id, stock_level, price | FK → medicines |
| `staff` | staff_id (PK), role, login_credentials | Parent table for admin/courier |
| `couriers` | courier_id (PK), staff_id (FK), vehicle_type, availability | FK → staff |

### Cross-Validation Task
| Task | Action |
|------|--------|
| Method name sync | Verify `assignCourierToOrder()` exists in: Class Diagram → Sequence Diagram → Java code → DB DAO |

---

## 📦 PHASE 3 DELIVERABLES (Your Contribution)

### Database Implementation
- [ ] Create Derby DB schema with 5+ tables matching Class Diagram
- [ ] Implement foreign key constraints (especially Order→Payment composition)
- [ ] Write sample INSERT/SELECT queries for testing
- [ ] Screenshot: DB schema diagram + query results

### Code Implementation
- [ ] Implement `assignCourierToOrder()` method with DB integration
- [ ] Create DAO layer for `Inventory` table operations
- [ ] Screenshot: Courier assignment UI with database confirmation

### Report Sections
- [ ] Write DB Schema section with ER diagram
- [ ] Document table relations and composition logic
- [ ] Add your code + DB screenshots with brief descriptions

### Oral Defense Prep
**TA Will Ask:**
- "How does your DB schema reflect the Composition relationship between Order and Payment?"
  → Answer: "Payment table has order_id as FK with ON DELETE CASCADE, ensuring Payment cannot exist without Order."
- "Why did you choose single-table inheritance for Staff/Admin/Courier?"
  → Answer: "Simplifies queries and aligns with our use case where Admin/Courier share login behavior."

---

## ✅ CHECKLIST

| Task | Status | Deadline |
|------|--------|----------|
| Design DB schema matching Class Diagram | ⬜ | Day 2 |
| Implement Derby DB tables + constraints | ⬜ | Day 3 |
| Code assignCourierToOrder() with DB integration | ⬜ | Day 4 |
| Take 2 screenshots (schema + UI) | ⬜ | Day 5 |
| Write DB section for report | ⬜ | Day 6 |
| Oral prep Q&A practice | ⬜ | Day 7 |

---

## 🚨 REMINDERS
- **No AI for submission content** → Rewrite everything in your own words
- **Merge P1+P2** → Your DB work goes into the ONE combined report
- **Oral = 25% of project mark** → Be ready to explain schema decisions

**Next:** Start DB schema design TODAY. Coordinate with Adel on Class Diagram first. 🫡
