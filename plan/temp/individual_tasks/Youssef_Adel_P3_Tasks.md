# 🎯 Youssef Adel (258270) - Phase 3 Individual Tasks
**Grade:** A | **Focus:** Activity Diagram 4 + Class Diagram Leadership

---

## 🔧 YOUR SPECIFIC PHASE 2 FIXES

### Activity Diagram 4 (Your Diagram)
| Issue | Fix | UML Rule |
|-------|-----|----------|
| Mixed perspectives (Admin vs System) | **Pick ONE viewpoint**: Either `Admin` swimlane OR `System` swimlane, NOT both | Lab 6: Activity diagrams must use consistent perspective |
| **Action** | Redraw with `Admin` as primary actor swimlane. System actions go in `System` partition if using actor-centric style. | Keep it simple: Actor actions on left, system responses on right |

### Class Diagram (Team Task - You Lead)
| #   | Fix                                                   | Your Action                                                                                                  |
| --- | ----------------------------------------------------- | ------------------------------------------------------------------------------------------------------------ |
| 1   | FRs as methods in correct classes                     | Map Phase 1 FRs to class methods: `processOrder()` in `Customer`, `manageMedicineInventory()` in `Inventory` |
| 2   | Missing relation names                                | Add labels: `places`, `manages`, `assigns`, `confirms`                                                       |
| 3   | Order ↔ Payment composition                           | Use **filled diamond** on Order side (Payment dies with Order)                                               |
| 4   | Remove DeliveryAddress/OrderItem/TrackingInfo classes | Convert to attributes in `Order` class                                                                       |
| 5   | Add `Inventory` class                                 | Create with `stockLevel`, `price`, `expiryDate` attributes                                                   |
| 6   | Add `Staff` abstract class                            | `Administrator` and `Courier` inherit from `Staff`                                                           |
| 7   | Remove arrow shapes on associations                   | Use plain lines with multiplicity only                                                                       |
| 8   | **Cross-validation**                                  | ✅ Verify method names match: Class Diagram ↔ Sequence Diagrams ↔ Java code                                   |

---

## 📦 PHASE 3 DELIVERABLES (Your Contribution)

### Code Implementation
- [ ] Implement `Inventory` class methods: `updateStock()`, `checkAvailability()`
- [ ] Implement `Staff` inheritance pattern in Java
- [ ] Screenshot: Inventory management UI with stock update functionality

### Report Sections
- [ ] Write Activity Diagram 4 description (1 paragraph, actor-centric perspective)
- [ ] Document Class Diagram fixes (your 7 items above)
- [ ] Add your code screenshots with brief output descriptions

### Oral Defense Prep
**TA Will Ask:**
- "Why did you choose Admin-centric perspective for your activity diagram?"
  → Answer: "Admin is the primary actor for inventory management; system actions are responses to admin triggers."
- "How does your Class Diagram align with Phase 1 FRs?"
  → Answer: "Each FR maps to a method in the class that owns the data. Example: FR-01 'Manage Medicine Inventory' → `Inventory.updateStock()` method."

---

## ✅ CHECKLIST

| Task | Status | Deadline |
|------|--------|----------|
| Fix Activity Diagram 4 perspective | ⬜ | Day 1 |
| Lead Class Diagram fixes (7 items) | ⬜ | Day 2 |
| Implement Inventory class code | ⬜ | Day 4 |
| Take 2 code screenshots | ⬜ | Day 5 |
| Write report sections | ⬜ | Day 6 |
| Oral prep Q&A practice | ⬜ | Day 7 |

---

## 🚨 REMINDERS
- **No AI for submission content** → Rewrite everything in your own words
- **Merge P1+P2** → Your fixes go into the ONE combined report
- **Oral = 25% of project mark** → Know your diagrams cold

**Next:** Start with Activity Diagram 4 redraw TODAY. 🫡
