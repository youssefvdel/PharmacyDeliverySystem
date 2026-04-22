# 🚀 Phase 3 Master Plan - Group 39
**Pharmacy Delivery System** | **Target: 100% Compliance + Top Marks**
**Prepared by:** Luna (Engineering Mentor) | **Date:** April 2026

---

## 📋 Phase 3 Deliverables (Per Email)

| Deliverable | Details | Status |
|-------------|---------|--------|
| **Final Report** | Merge P1+P2 + fixes + DB schema + code screenshots | ☐ |
| **Code** | Desktop GUI (Java) + Derby DB + exception handling | ☐ |
| **Screenshots** | 5 functionalities, each with output description | ☐ |
| **Oral Discussion** | Week 13, 25% of project mark | ☐ |

**Deadline:** Friday 24/4/2026 ⚠️

---

## 🔧 Phase 2 Feedback Fixes (14 Items)

### Class Diagram (7 Fixes)
| # | Feedback | Fix | Owner |
|---|----------|-----|-------|
| 1 | FRs as methods in correct classes | `Customer.processOrder()`, `Pharmacist.manageInventory()` | Team |
| 2 | Missing relation names | `Customer "places" Order`, `Pharmacist "manages" Inventory` | Team |
| 3 | Order↔Payment relationship | Change to **Composition** (filled diamond on Order) | Team |
| 4 | DeliveryAddress/OrderItem/TrackingInfo as classes | Remove as classes → add as `Order` attributes | Team |
| 5 | Need `Inventory` class | Add with `stockLevel`, `price`, `expiryDate`, methods | Youssef A |
| 6 | Might need `Staff` class | Add abstract `Staff`, make `Admin`/`Courier` inherit | Team |
| 7 | No arrow shape/direction in relationships | Remove arrowheads → use plain lines with multiplicity | Team |

### Activity Diagrams (4 Fixes)
| Member | Feedback | Fix |
|--------|----------|-----|
| Yosef Gad | Mixed perspectives | Use **ONE viewpoint**: Actor-centric OR System-centric swimlanes |
| Youssef Adel | Mixed perspectives | Same as above - consistent across all 4 diagrams |
| Yousef Mohiey | Missing join bar | Add **thick horizontal join** where parallel flows merge |
| Yousif Hafez | Multiple end nodes | Reduce to **ONE Activity Final Node** per diagram |

### Sequence Diagrams (3 Fixes)
| # | Feedback | Fix | Owner |
|---|----------|-----|-------|
| 1 | Missing functionality names | Add header: `Sequence Diagram: [Use Case Title]` | All |
| 2 | Mohiey: `alt` frame too narrow | Stretch `alt` to cover **ALL** involved lifelines | Yousef M |
| 3 | Hafez: Customer missing activation bar | Add thin vertical rectangle on Customer lifeline | Yousif H |

---

## 📅 3-Week Execution Timeline

### WEEK 1 (Now - 10/4): DIAGRAM FIXES 🔧
```
Day 1-2: Class Diagram Fixes (7 items)
  ✓ Add Inventory class + attributes/methods
  ✓ Add FR methods to correct classes
  ✓ Add relation names to associations
  ✓ Change Order↔Payment to Composition
  ✓ Remove redundant classes → move to attributes
  ✓ Add Staff abstract class + inheritance
  ✓ Remove arrowheads on associations

Day 3-4: Activity Diagram Fixes (4 items)
  ✓ Fix perspective: Choose ONE swimlane view
  ✓ Add JOIN bars where parallel flows merge
  ✓ Reduce to ONE end node per diagram
  ✓ Verify fork/join balance

Day 5-6: Sequence Diagram Fixes (3 items)
  ✓ Add Use Case title at top of each diagram
  ✓ Stretch alt frames to cover ALL lifelines
  ✓ Add activation bars on all interacting lifelines

Day 7: Diagram Validation
  ✓ Cross-check: Class↔Sequence↔Activity↔Use Case alignment
  ✓ Naming audit: All names match Phase 1 exactly
  ✓ Export as high-res PNG for report
```

### WEEK 2 (11/4 - 17/4): CODE + DB + REPORT MERGE 💻
```
Day 8-10: Database Schema Design
  ✓ Design ERD based on FIXED Class Diagram
  ✓ Tables: Customer, Medicine, Order, OrderItem, Courier, Payment, Address, Staff
  ✓ Define PK/FK, data types, constraints
  ✓ Map Composition: CASCADE DELETE rules
  ✓ Export as PNG + SQL DDL script

Day 11-14: Code Implementation (5 Functionalities)
  [Youssef A] UC_01: Manage Inventory → GUI + Derby CRUD + try/catch
  [Yousef M] UC_02: Place Order → GUI + validation + exception handling
  [Yousif H] UC_03: Track Order → GUI + status updates + error handling
  [Yosef G] UC_04: Manage Profile → GUI + update logic + try/catch
  [Tarek S] UC_05: Assign Courier → GUI + assignment logic + exception handling
  
  Code Standards:
  ✓ Java Swing/JavaFX for GUI
  ✓ Derby embedded database
  ✓ try/catch on ALL database + user input operations
  ✓ Comments: Class header, method Javadoc, complex logic inline
  ✓ Build script: clear README for compilation

Day 15: Code Screenshots + Documentation
  ✓ Each member: 3 screenshots (input, success output, error handling)
  ✓ Brief description for each: "This shows [feature] handling [scenario]"
  ✓ Compile into report section with captions

Day 16-17: Report Merge + Final Polish
  ✓ Merge P1+P2+fixes+DB+code into ONE PDF
  ✓ Consistent formatting: headings, captions, page numbers
  ✓ Update Contribution Table with Phase 3 work
  ✓ Proofread: spelling, grammar, references, page breaks
  ✓ Export to PDF (<10MB for e-learning)
```

### WEEK 3 (18/4 - 24/4): ORAL PREP + SUBMISSION 🎤
```
Day 18-19: Individual Oral Prep
  ✓ Know YOUR diagrams:
    - "Why processOrder() in Customer?" → "Customer owns order initiation per FR-02"
    - "Why Composition for Payment?" → "No independent lifecycle; meaningless without Order"
    - "Why remove DeliveryAddress class?" → "Value object with no behavior; reduces coupling"
    - "How does Activity match Use Case?" → Walk through step-by-step mapping
  
  ✓ Know YOUR code:
    - "Show exception handling" → Demo try/catch block
    - "How does GUI connect to DB?" → Explain JDBC/Derby flow
    - "What happens with invalid input?" → Show validation + error flow
    - "How did you test?" → Describe test cases + edge cases
  
  ✓ Practice: 2-min explanation of your contribution (clear, confident, technical)

Day 20: Team Rehearsal
  ✓ Mock Q&A: TA asks random questions, members respond
  ✓ Diagram walkthrough: Project leader presents full system flow
  ✓ Code demo: Run app live, show 1-2 key functionalities
  ✓ Identify weak spots: Peer coaching session
  ✓ Finalize talking points: 3 key design decisions to emphasize

Day 21: Final Validation Checklist ⚠️
  Report:
  ☐ P1+P2 merged into ONE document
  ☐ All 14 feedback items applied + verified
  ☐ DB Schema included (ERD + DDL)
  ☐ 5 code screenshots with descriptions
  ☐ Contribution table updated
  ☐ PDF exported, file size <10MB
  
  Code:
  ☐ All 5 functionalities implemented + buildable
  ☐ Exception handling on all risky operations
  ☐ Derby schema matches Class Diagram
  ☐ Code commented, organized, no hardcoded paths
  ☐ README with build/run instructions
  
  Oral Prep:
  ☐ Every member can explain diagrams + code
  ☐ Team can articulate 3 key design decisions
  ☐ Mock Q&A completed (8/10 minimum pass)
  ☐ Discussion schedule confirmed (Week 13)

Day 22 (24/4): SUBMISSION DAY 🚀
  ☐ Morning: Final proofread of PDF + code zip
  ☐ Afternoon: Upload to e-learning BEFORE deadline
  ☐ Evening: Team confirmation + backup copies saved
  ☐ Post-submission: Rest, then prep for Week 13 discussion
```

---

## 🛡️ Risk Mitigation + Quality Gates

### Key Risks + Mitigations
| Risk | Mitigation | Gate |
|------|-----------|------|
| Diagram fixes cause cascade changes | Fix Class Diagram FIRST, then update others | Method Name Audit after Class fixes |
| Code doesn't match diagrams | Create "Method Contract" doc before coding | Code review: "Does method exist in Class Diagram?" |
| Oral defense unprepared (25% of mark!) | Start prep Week 2, assign question owners | Mock Q&A scorecard: 8/10 minimum pass |
| Last-minute merge errors | Use Git for report drafts; merge early | "Report Freeze" at Day 19 |
| Derby integration fails | Use Week 11 lab example; test DB Day 11 | "DB Smoke Test" before proceeding |

### Quality Gates (Must Pass)
```
Gate A: Diagram Fixes Complete (End Week 1)
  ☐ All 14 feedback items addressed
  ☐ Cross-diagram consistency verified
  ☐ Naming audit passed (100% match with Phase 1)
  ☐ Diagrams exported as high-res PNG, labeled

Gate B: Code + DB Complete (End Week 2, Day 14)
  ☐ All 5 functionalities implemented + buildable
  ☐ Exception handling verified (try/catch on all risky ops)
  ☐ Derby schema matches Class Diagram
  ☐ Code screenshots captured + described
  ☐ Peer code review completed

Gate C: Report Merge Complete (End Week 2, Day 17)
  ☐ Single PDF document (P1+P2+fixes+DB+code)
  ☐ Contribution table updated with Phase 3 work
  ☐ Formatting consistent, page numbers, captions
  ☐ PDF size <10MB, all images readable
  ☐ Team lead + 1 reviewer sign-off

Gate D: Oral Prep Complete (End Week 3, Day 21)
  ☐ Each member passed mock Q&A (8/10 minimum)
  ☐ Team can articulate 3 key design decisions confidently
  ☐ Live demo runs without errors
  ☐ Discussion schedule confirmed, backup plan ready
```

---

## 🎯 Success Metrics

### Diagram Quality (40% of project)
- ✅ All 14 TA feedback items resolved (zero open issues)
- ✅ UML 2.5 compliant (per Lecture 4-6, Lab materials)
- ✅ Naming consistency: 100% match with Phase 1 FRs/Use Cases
- ✅ Cross-diagram alignment: Every method in Class appears in Sequence; every action in Activity maps to Use Case step
- ✅ Visual clarity: High-res exports, proper labels, readable fonts

### Implementation Quality (35% of project)
- ✅ 5 functionalities implemented (one per member, excluding signup/login)
- ✅ Exception handling: try/catch on ALL database + user input operations
- ✅ Derby integration: Schema matches Class Diagram, CRUD operations work
- ✅ Code quality: Comments, organization, buildable, no hardcoded paths
- ✅ Screenshots: Clear, annotated, demonstrate success + error cases

### Documentation + Oral Quality (25% of project)
- ✅ Single merged report, professional formatting
- ✅ Contribution table: Accurate, detailed, Phase 3 work included
- ✅ Oral prep: Every member confident, can explain design decisions, demo works
- ✅ Discussion readiness: Mock Q&A passed, weak areas addressed
- ✅ Submission: On time, correct format, backup saved

---

## 🧠 Oral Defense Cheat Sheet (Key Q&A)

### Design Decision Questions
**Q: "Why did you use Composition for Order→Payment?"**
> A: "Payment is a value object that has no independent lifecycle. If an Order is deleted, its associated Payment history for that transaction is no longer meaningful to the system scope. Composition enforces this lifecycle dependency, which aligns with the business rule that payments are always tied to specific orders."

**Q: "Why did you remove DeliveryAddress as a separate class?"**
> A: "DeliveryAddress doesn't have independent behavior or lifecycle—it's purely data that describes where an Order should be delivered. Keeping it as a separate class would violate the Single Responsibility Principle and add unnecessary coupling. By making it an attribute of Order (or Customer for saved addresses), we reduce complexity while maintaining all required functionality."

**Q: "How do your Sequence diagrams align with your Class Diagram?"**
> A: "Every message in our Sequence diagrams maps directly to a public method in the receiver class from our Class Diagram. For example, when AdminPanel calls `updateStock()` on InventoryController, that method exists in the InventoryController class with the exact same signature. We avoid cross-layer calls without control classes to maintain proper separation of concerns."

### Code Implementation Questions
**Q: "Show me where you implemented exception handling."**
> [Demo] "Here in the `placeOrder()` method, we wrap the database insert in a try-catch block. If the Derby connection fails or a constraint violation occurs, we catch the SQLException, log the error, and display a user-friendly message instead of crashing the application."

**Q: "How does your GUI connect to the database?"**
> [Explain] "We use JDBC to connect to the embedded Derby database. The connection string is configured in a properties file for easy maintenance. We use prepared statements for all queries to prevent SQL injection, and we always close connections in a finally block to prevent resource leaks."

**Q: "What happens if the user enters invalid data?"**
> [Demo] "Before any database operation, we validate user input. For example, in the 'Add Medicine' form, we check that price is positive, stock is non-negative, and name is not empty. If validation fails, we highlight the problematic field and show an error message—no database call is made, preventing invalid data from entering the system."

### System Design Questions
**Q: "How does your Activity diagram match the Use Case scenario?"**
> [Walk through] "Starting from the Use Case 'Manage Inventory': Step 1 'Admin navigates to inventory' maps to our first activity 'Navigate to Inventory Management'. Step 2 'Admin searches for medicine' maps to 'Search for medicine by name or ID'. Every extension in the Use Case (like 'Medicine not found') has a corresponding decision node and alternative path in our Activity diagram."

**Q: "Why did you choose Actor-centric swimlanes for Activity diagrams?"**
> A: "Actor-centric swimlanes make it clearer who is responsible for each action, which aligns with our Use Case modeling where actors drive the interactions. It also makes the diagrams easier to validate against the Use Case scenarios during oral defense, as we can trace each actor's actions step-by-step."

---

## ✅ Final Submission Checklist

```
[ ] Report (PDF)
  [ ] Single document (P1+P2 merged)
  [ ] All 14 feedback fixes applied + documented
  [ ] DB Schema: ERD + DDL script included
  [ ] 5 code screenshots with descriptions
  [ ] Contribution table updated
  [ ] Formatting: consistent headings, captions, page numbers
  [ ] File size <10MB
  [ ] Proofread: spelling, grammar, references

[ ] Code (ZIP)
  [ ] All 5 functionalities implemented
  [ ] Exception handling (try/catch) on all risky operations
  [ ] Derby database schema matches Class Diagram
  [ ] Code commented, organized, buildable
  [ ] README with build/run instructions
  [ ] No hardcoded paths or credentials

[ ] Oral Prep
  [ ] Each member passed mock Q&A (8/10 minimum)
  [ ] Team can articulate 3 key design decisions
  [ ] Live demo runs without errors
  [ ] Discussion schedule confirmed (Week 13 slot)
  [ ] Backup plan ready (what if tech fails?)

[ ] Submission
  [ ] Uploaded to e-learning BEFORE deadline (24/4/2026)
  [ ] Confirmation email received
  [ ] Backup copies saved (local + cloud)
  [ ] Team confirmation: all members reviewed final submission
```

---

## 🏆 Success Definition

> "Submit a Phase 3 package that requires **ZERO revisions** from TA feedback, demonstrates **deep understanding** of software engineering principles, and positions Group 39 for **top marks** in both written and oral assessment."

**Remember:** You have the knowledge. Apply these fixes precisely. Submit clean. Defend confidently. 🚀

---

*Plan prepared by Luna | Engineering Mentor Protocol v2.1 | ADHD-Optimized Format*