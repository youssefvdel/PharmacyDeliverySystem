# 🎯 Yosef Gad (255796) - Phase 3 Individual Tasks
**Grade:** B | **Focus:** Activity Diagram 1 + Extra Attention Needed

---

## 🔧 YOUR SPECIFIC PHASE 2 FIXES

### Activity Diagram 1 (Your Diagram) - HIGH PRIORITY
| Issue                                   | Fix                                                                                                                  | UML Rule                                                 |          |
| --------------------------------------- | -------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------- | -------- |
| Mixed perspectives (Customer vs System) | **Pick ONE viewpoint**: Either `Customer` swimlane OR `System` swimlane, NOT both                                    | Lab 6: Activity diagrams must use consistent perspective |          |
| **Action**                              | Redraw with `Customer` as primary actor swimlane. All customer actions in left lane, system responses in right lane. | Use partition notation: `Customer`                       | `System` |

### Class Diagram (Team Task)
| # | Fix | Your Action |
|---|-----|-------------|
| 1 | FRs as methods in correct classes | Ensure `manageCustomerProfile()` method in `Customer` class |
| 2 | Missing relation names | Add `manages` label on Customer→Profile association |
| 3 | Order ↔ Payment composition | Verify composition logic in your sequence diagrams |
| 4 | Remove extra classes | Confirm `TrackingInfo` is now attribute in `Order` |
| 5 | Add `Inventory` class | Understand how Customer interacts with Inventory (read-only) |
| 6 | Add `Staff` abstract class | Note: Customer does NOT inherit from Staff |
| 7 | Remove arrow shapes | Use plain lines in your diagram exports |

---

## 📦 PHASE 3 DELIVERABLES (Your Contribution)

### Code Implementation
- [ ] Implement `manageCustomerProfile()` method (CRUD operations)
- [ ] Add profile validation logic (address format, phone validation)
- [ ] Screenshot: Customer profile UI with edit/save functionality

### Report Sections
- [ ] Rewrite Activity Diagram 1 description (customer-centric perspective)
- [ ] Document your Class Diagram contributions
- [ ] Add your code screenshots with brief output descriptions
- [ ] **Extra**: Add a "Lessons Learned" note about perspective consistency

### Oral Defense Prep (Extra Practice for B Grade)
**TA Will Ask:**
- "What was wrong with your original Activity Diagram perspective?"
  → Answer: "I mixed actor and system actions in the same swimlane, which violates Lab 6 rules. I fixed it by using customer-centric partitions."
- "How does manageCustomerProfile() handle data validation?"
  → Answer: "It validates address format and phone number before saving, returning error messages for invalid input."
- "Why merge Phase 1 + 2 + 3 into ONE report?"
  → Answer: "Merging ensures traceability: Requirements (P1) → Design (P2) → Implementation (P3). Shows full system understanding."

**Practice These Q&A 3x before oral session.**

---

## ✅ CHECKLIST

| Task | Status | Deadline |
|------|--------|----------|
| Fix Activity Diagram 1 perspective | ⬜ | Day 1 (HIGH) |
| Implement manageCustomerProfile() code | ⬜ | Day 3 |
| Add validation logic + error handling | ⬜ | Day 4 |
| Take 2 screenshots (UI + validation) | ⬜ | Day 5 |
| Write report sections + lessons learned | ⬜ | Day 6 |
| Oral prep Q&A practice (3x) | ⬜ | Day 7 |

---

## 🚨 REMINDERS
- **Grade B means extra scrutiny** → Double-check all fixes
- **No AI for submission content** → Rewrite everything in your own words
- **Merge P1+P2** → Your fixes go into the ONE combined report
- **Oral = 25% of project mark** → Practice answers out loud

**Next:** Fix Activity Diagram 1 perspective TODAY. Show to team for review before moving on. 🫡
