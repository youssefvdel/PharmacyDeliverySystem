# 🎯 Yousef Mohiey (248679) - Phase 3 Individual Tasks
**Grade:** A | **Focus:** Activity Diagram 2 + Sequence Diagram 1

---

## 🔧 YOUR SPECIFIC PHASE 2 FIXES

### Activity Diagram 2 (Your Diagram)
| Issue | Fix | UML Rule |
|-------|-----|----------|
| Missing join bar | **Add thick horizontal join bar** where parallel flows merge before end | Lab 6: Fork/Join must balance - all parallel actions must merge |
| **Action** | After any `<fork>` with parallel actions, add a `==== Join ====` bar before continuing to next action or end node. | All parallel paths → join → single flow |

### Sequence Diagram 1 (Your Diagram)
| Issue | Fix | UML Rule |
|-------|-----|----------|
| alt frame too narrow | **Stretch `alt` frame** to cover ALL involved lifelines, not just Order/Payment | Lecture 5: Combined fragments span all participating objects |
| Missing functionality name | **Add Use Case title** at top: "Sequence Diagram: Manage Order" | Lab 3: Each diagram must be labeled with its functionality |
| **Action** | Expand `alt` frame horizontally + add title header | Frame encloses all objects; title at top-center |

### Class Diagram (Team Task)
| # | Fix | Your Action |
|---|-----|-------------|
| 1 | FRs as methods in correct classes | Ensure `processCustomerOrder()` method in `Customer` class |
| 2 | Missing relation names | Add `places` label on Customer→Order association |
| 3 | Order ↔ Payment composition | Your sequence diagram must show Order creating Payment |
| 4 | Remove extra classes | Confirm `OrderItem` is now attribute/list in `Order` |
| 5 | Add `Inventory` class | Sequence: Order checks Inventory before confirming |
| 6 | Add `Staff` abstract class | Note: Order process may involve Staff for assignment |
| 7 | Remove arrow shapes | Use plain lines in your diagram exports |

---

## 📦 PHASE 3 DELIVERABLES (Your Contribution)

### Code Implementation
- [ ] Implement `processCustomerOrder()` method with full workflow
- [ ] Add parallel processing: payment + inventory check (fork/join pattern)
- [ ] Implement `alt` logic: success path vs. payment failure path
- [ ] Screenshot: Order placement UI with success/error handling

### Report Sections
- [ ] Rewrite Activity Diagram 2 description (with join bar)
- [ ] Document Sequence Diagram 1 fixes (alt frame expanded)
- [ ] Add your code screenshots with brief output descriptions
- [ ] Include a note on parallel processing implementation

### Oral Defense Prep
**TA Will Ask:**
- "Where exactly did you add the join bar in your activity diagram, and why?"
  → Answer: "After the parallel payment processing and inventory check actions. The join ensures both complete before order confirmation, preventing race conditions."
- "Which lifelines are included in your alt frame, and why?"
  → Answer: "Customer, OrderController, PaymentGateway, Inventory, and Notification. All participate in the alternative payment flow, so the frame must span them per UML rules."

---

## ✅ CHECKLIST

| Task | Status | Deadline |
|------|--------|----------|
| Fix Activity Diagram 2 (add join bar) | ⬜ | Day 1 |
| Fix Sequence Diagram 1 (expand alt frame) | ⬜ | Day 2 |
| Implement processCustomerOrder() with fork/join | ⬜ | Day 4 |
| Add alt logic for payment success/failure | ⬜ | Day 5 |
| Take 2 screenshots (order UI + error handling) | ⬜ | Day 5 |
| Write report sections + parallel processing note | ⬜ | Day 6 |
| Oral prep Q&A practice | ⬜ | Day 7 |

---

## 🚨 REMINDERS
- **No AI for submission content** → Rewrite everything in your own words
- **Merge P1+P2** → Your fixes go into the ONE combined report
- **Oral = 25% of project mark** → Be ready to explain fork/join and alt frame logic

**Next:** Fix Activity Diagram 2 join bar TODAY, then expand Sequence Diagram 1 alt frame. Coordinate with team on Class Diagram changes. 🫡
