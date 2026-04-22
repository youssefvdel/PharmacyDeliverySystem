# 🎯 Yousif Hafez (258612) - Phase 3 Individual Tasks
**Grade:** A | **Focus:** Activity Diagram 3 + Sequence Diagram 2

---

## 🔧 YOUR SPECIFIC PHASE 2 FIXES

### Activity Diagram 3 (Your Diagram)
| Issue | Fix | UML Rule |
|-------|-----|----------|
| Multiple end nodes | **Keep ONLY ONE Activity Final Node** at the bottom of diagram | Lab 6: Only one end node per activity diagram |
| **Action** | Merge all success/error paths into a single `🎯 End` node. Use merge diamonds to combine branches before the final node. | All flows → merge → single end |

### Sequence Diagram 2 (Your Diagram)
| Issue | Fix | UML Rule |
|-------|-----|----------|
| Customer missing activation bar | **Add vertical rectangle** on Customer lifeline during interaction | Lecture 5: Actors get activation bars when sending/receiving messages |
| Missing functionality name | **Add Use Case title** at top: "Sequence Diagram: Track Order" | Lab 3: Each diagram must be labeled with its functionality |
| **Action** | Draw thin vertical bar on Customer lifeline + add title header | Bar spans interaction; title at top-center |

### Class Diagram (Team Task)
| # | Fix | Your Action |
|---|-----|-------------|
| 1 | FRs as methods in correct classes | Ensure `trackOrderStatus()` method in `Customer` class |
| 2 | Missing relation names | Add `tracks` label on Customer→Order association |
| 3 | Order ↔ Payment composition | Verify in your sequence: Order creates Payment |
| 4 | Remove extra classes | Confirm `TrackingInfo` is attribute in `Order` |
| 5 | Add `Inventory` class | Note: Customer reads inventory (view medicines) |
| 6 | Add `Staff` abstract class | Document in sequence: Staff login inherited |
| 7 | Remove arrow shapes | Use plain lines in your diagram exports |

---

## 📦 PHASE 3 DELIVERABLES (Your Contribution)

### Code Implementation
- [ ] Implement `trackOrderStatus()` method with real-time status updates
- [ ] Add status enum: `PENDING`, `OUT_FOR_DELIVERY`, `DELIVERED`
- [ ] Screenshot: Order tracking UI showing status progression

### Report Sections
- [ ] Rewrite Activity Diagram 3 description (single end node)
- [ ] Document Sequence Diagram 2 fixes (activation bar added)
- [ ] Add your code screenshots with brief output descriptions

### Oral Defense Prep
**TA Will Ask:**
- "Why did you have multiple end nodes originally, and how did you fix it?"
  → Answer: "I had separate ends for success/error paths. I fixed it by merging all branches into one final node, as Lab 6 requires."
- "When does the Customer activation bar start and end in your sequence diagram?"
  → Answer: "It starts when Customer sends 'trackOrder()' message and ends when System returns 'statusUpdate' response."

---

## ✅ CHECKLIST

| Task | Status | Deadline |
|------|--------|----------|
| Fix Activity Diagram 3 (single end node) | ⬜ | Day 1 |
| Fix Sequence Diagram 2 (Customer activation bar) | ⬜ | Day 2 |
| Implement trackOrderStatus() code | ⬜ | Day 4 |
| Add status enum + UI updates | ⬜ | Day 5 |
| Take 2 screenshots (tracking UI) | ⬜ | Day 5 |
| Write report sections | ⬜ | Day 6 |
| Oral prep Q&A practice | ⬜ | Day 7 |

---

## 🚨 REMINDERS
- **No AI for submission content** → Rewrite everything in your own words
- **Merge P1+P2** → Your fixes go into the ONE combined report
- **Oral = 25% of project mark** → Know your diagram fixes cold

**Next:** Fix Activity Diagram 3 end node TODAY, then Sequence Diagram 2 activation bar. 🫡
