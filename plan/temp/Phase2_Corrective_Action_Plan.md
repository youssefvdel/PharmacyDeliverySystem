# 🛠️ Phase 2 Feedback: Corrective Action Plan
**Project:** Pharmacy Delivery System | **Group:** 39 | **Target:** 100% Compliance with TA Feedback & Course Standards
**Prepared by:** Luna (Engineering Mentor) | **Date:** 2024

---

## 📦 GENERAL DIRECTIVE
| Requirement            | Action                                                                                                                                       |
| ---------------------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| **Merge Reports**      | Combine Phase 1 & 2 into **ONE unified document**. Do NOT submit separate files.                                                             |
| **Document Order**     | 1. Project Desc → 2. FRs/NFRs → 3. Context → 4. Use Case → 5. Class → 6. Activity (5) → 7. Sequence (5) → 8. DB Schema → 9. Code Screenshots |
| **Naming Consistency** | All diagram titles, class names, and method names must **exactly match** Phase 1 FRs and Use Case titles.                                    |

---

## 📐 CLASS DIAGRAM (7 Fixes)
*Reference: Lecture 4 (Slides 6-25), Lab 1 FR Rules*

| #   | TA Feedback                                              | UML/Course Rule                                                    | Exact Fix for Your System                                                                                                                                    |
| --- | -------------------------------------------------------- | ------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| 1   | **FRs as methods in correct classes**                    | Each FR maps to a method in the class that owns the data/behavior. | `Customer` → `processOrder()`, `trackOrderStatus()`, `manageCustomerProfile()`<br>`Pharmacist/Admin` → `manageMedicineInventory()`, `assignCourierToOrder()` |
| 2   | **Missing relation names**                               | Associations should have meaningful role names (Lecture 4).        | `Customer` `places` `Order`<br>`Pharmacist` `manages` `Inventory`<br>`Admin` `assigns` `Courier`                                                             |
| 3   | **Order ↔ Payment relationship**                         | Payment cannot exist without Order → **Composition**.              | Draw **filled diamond** on `Order` side pointing to `Payment`. Lifetime is tied to Order.                                                                    |
| 4   | **DeliveryAddress, OrderItem, TrackingInfo not classes** | These are value objects/attributes, not independent entities.      | ❌ Delete these 3 classes.<br>✅ Add as attributes in `Order`: `deliveryAddress: String`, `items: List<Item>`, `trackingStatus: String`                        |
| 5   | **Need `Inventory` class**                               | Matches FR-01. Must track stock/pricing.                           | ✅ Create `Inventory` class.<br>Attributes: `stockLevel: int`, `price: double`, `expiryDate: Date`<br>Methods: `updateStock()`, `checkAvailability()`         |
| 6   | **Might need `Staff` class**                             | Matches Use Case inheritance (Admin/Courier inherit login).        | ✅ Create `Staff` (abstract).<br>`Administrator` and `Courier` inherit from `Staff` (hollow triangle arrow). `Staff` holds `login()` method.                  |
| 7   | **No arrow shape/direction in relationships**            | Course simplifies early design to bidirectional associations.      | ❌ Remove all open arrowheads on association lines.<br>✅ Use **plain lines** with multiplicity (e.g., `1` ────── `0..*`)                                      |

---

## 🔄 ACTIVITY DIAGRAMS (4 Fixes)
*Reference: Lab 6 (Slides 1-10), Case Study Examples*

| Member | TA Feedback | UML/Course Rule | Exact Fix |
|--------|-------------|-----------------|-----------|
| **Yosef Gad** | Mixed perspectives | Activity diagrams must use **ONE viewpoint** (Actor-centric OR System-centric). | ✅ Use **Actor-centric swimlanes**: `Customer` \| `System` \| `Database` (if used). Do NOT mix `UI` and `Actor` lanes in same diagram. |
| **Youssef Adel** | Mixed perspectives | Same as above. | ✅ Use **Actor-centric swimlanes**: `Admin` \| `System` \| `Inventory Service`. Keep consistent across all 4 diagrams. |
| **Yousef Mohiey** | Missing join bar | Fork/Join must balance. Parallel flows MUST merge before end. | ✅ Add **thick horizontal join bar** after parallel actions. All flows enter join → single flow exits to end node. |
| **Yousif Hafez** | Multiple end nodes | Lab 6 explicitly states: **Only one Activity Final Node** per diagram. | ✅ Delete extra `🎯` nodes. Merge all success/error paths into **ONE** final node at the bottom. |

**📐 Activity Diagram Structure Template:**
```
[Start] → (Action 1) → <Decision> → (Action 2a) → [Join Bar] → (Action 3) → [End]
                      ↘ (Action 2b) ↗
```

---

## ⏱️ SEQUENCE DIAGRAMS (3 Fixes)
*Reference: Lecture 5 (Slides 4-15), Mapping Guidelines*

| # | TA Feedback | UML/Course Rule | Exact Fix |
|---|-------------|-----------------|-----------|
| 1 | **Missing functionality names** | Each sequence diagram must be titled with its Use Case. | ✅ Add header: `Sequence Diagram: Manage Order` (top center). Match exactly with Use Case title. |
| 2 | **Mohiey: `alt` frame too narrow** | `alt`/`opt`/`loop` frames must span **ALL involved lifelines**. | ✅ Stretch `alt` frame horizontally to cover `Customer`, `OrderController`, `PaymentGateway`, `Inventory`. Do NOT leave lifelines outside the frame. |
| 3 | **Hafez: Customer missing bar** | Actors get activation bars during interaction. | ✅ Add **thin vertical rectangle** on `Customer` lifeline from first message sent until last reply received. |

**📐 Sequence Diagram Checklist:**
- [ ] Lifelines = Objects/Actors (no `Database` class, use `Entity` objects)
- [ ] Messages = Method names from Class Diagram
- [ ] `alt` frames span all participating objects
- [ ] Activation bars on all interacting lifelines (including actors)
- [ ] Reply messages = dashed arrows with `return`

---

## 🛠️ EXECUTION WORKFLOW
1. **Fix Class Diagram First** → It drives Sequence Diagram updates.
2. **Update Sequence Diagrams** → Ensure messages match new Class methods.
3. **Fix Activity Diagrams** → Apply perspective rule + join/end node fixes.
4. **Merge Reports** → Combine P1 + P2 + Fixes + DB Schema + Code Screenshots.
5. **Final Validation** → Run through the checklist below before PDF export.

---

## 🧠 MENTOR NOTES (For Oral Defense)
- **TA will ask:** *"Why Composition for Payment?"* → Answer: *"Payment is a value object that has no meaning without an Order. If Order is deleted, Payment history for that transaction is irrelevant to the system scope."*
- **TA will ask:** *"Why remove DeliveryAddress as a class?"* → Answer: *"It doesn't have independent lifecycle or behavior. It's an attribute of Order/Customer. Keeping it as a class violates cohesion and overcomplicates the model."*
- **TA will ask:** *"How do your Sequence diagrams align with Class Diagram?"* → Answer: *"Every message in the sequence maps to a public method in the receiver class. No cross-layer calls without control classes."*

**You have the knowledge. Apply these fixes precisely. Submit clean. Defend confidently.** 🚀