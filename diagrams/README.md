# Fixed Diagrams for Phase 3

All diagrams recreated in Mermaid format with Phase 2 feedback fixes applied.

## How to Render
1. Copy `.mmd` file content to [Mermaid Live Editor](https://mermaid.live)
2. Or use Mermaid CLI: `mmdc -i file.mmd -o file.png`

## Files Created

### Class Diagram (Group)
| File | Fixes Applied |
|------|--------------|
| `class_diagram_fixed.mmd` | All 7 fixes: FR methods, relation names, Composition, removed classes, Inventory added, Staff abstract, no arrowheads |

### Activity Diagrams (Individual)
| File | Owner | Fixes Applied |
|------|-------|--------------|
| `AD_Youssef_fixed.mmd` | Youssef Adel | One perspective (Admin), ONE end node |
| `AD_Yosef_fixed.mmd` | Yosef Gad | One perspective (System), ONE end node |
| `AD_Mohiey_fixed.mmd` | Yousef Mohiey | Join bar at merge points, ONE end node |
| `AD_Hafez_fixed.mmd` | Yousif Hafez | ONE end node only |
| `AD_Tarek_fixed.mmd` | Tarek Saeed | One perspective (Admin), ONE end node |

### Sequence Diagrams (Individual)
| File | Owner | Fixes Applied |
|------|-------|--------------|
| `SD_Youssef_fixed.mmd` | Youssef Adel | Title added, alt spans all |
| `SD_Yosef_fixed.mmd` | Yosef Gad | Title added, alt spans all |
| `SD_Mohiey_fixed.mmd` | Yousef Mohiey | Title added, alt spans ALL lifelines |
| `SD_Hafez_fixed.mmd` | Yousif Hafez | Title added, activation bar on Customer |
| `SD_Tarek_fixed.mmd` | Tarek Saeed | Title added, alt spans all |

## Key Changes Summary

### Class Diagram
1. **FR Methods:** Added `processOrder()`, `trackOrderStatus()`, `manageCustomerProfile()` to Customer; `manageMedicineInventory()`, `assignCourierToOrder()` to Admin
2. **Relation Names:** `places`, `manages`, `assigns`, `delivered by`, `has`, `tracks`
3. **Composition:** Order *-- Payment (filled diamond)
4. **Removed Classes:** DeliveryAddress, OrderItem, TrackingInfo → now Order attributes
5. **Inventory Class:** New with `stockLevel`, `price`, `expiryDate`
6. **Staff Abstract:** Administrator and Courier inherit from Staff
7. **No Arrowheads:** Plain lines with multiplicity only

### Activity Diagrams
- **Youssef:** Removed System swimlane → Admin-centric only, reduced to 1 end node
- **Yosef:** Customer/System mixed → System perspective only, 1 end node
- **Mohiey:** Added join bars where parallel flows merge
- **Hafez:** Multiple end nodes → single end node
- **Tarek:** Ensured single perspective, single end node

### Sequence Diagrams
- **All:** Added title at top: `Sequence Diagram: [Use Case Title]`
- **Mohiey:** Alt frame stretched to cover all 5 lifelines
- **Hafez:** Added activation bar on Customer actor (activate/deactivate)

---

*Fixes based on Phase 2 TA Feedback for Group 39*
