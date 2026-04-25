# Pharmacy Delivery System — Phase 3 Guide

> **Course:** 25CSSE01C — Software Engineering I  
> **Group:** 39 | **TA:** Zeina  
> **Project:** Pharmacy Delivery System

---

## Team & Assignments

| Member | ID | Functionality | UC |
|---|---|---|---|
| Youssef Adel | 258270 | Manage Inventory | UC-01 |
| Tarek Saeed | 252382 | Assign Courier | UC-02 |
| Yosef Osama Gad | 255796 | Manage Profile | UC-03 |
| Yousif Hafez | 258612 | Track Order Status | UC-04 |
| Yousef Mohiey | 248679 | Manage Order | UC-05 |

---

## Phase 3 Deliverables Checklist

- [ ] Final report = **Phase 1 (corrected) + Phase 2 (corrected) + Phase 3** — all in ONE document
- [ ] Each member: at least 1 working GUI + functionality (not signup/login)
- [ ] Derby database integrated (no external ORM, plain JDBC)
- [ ] `try/catch` exception handling in every database operation
- [ ] GUI screenshots in report
- [ ] Contribution table updated

---

## Part 1 — Feedback Corrections

### 1.1 General

> [!warning] Critical — Costs marks if missed
> Phase 1 and Phase 2 **must be a single merged document**. Do not submit them separately. The Phase 3 report wraps everything: Phase 1 → Phase 2 → Phase 3 in one file.

---

### 1.2 Class Diagram — 7 Issues to Fix

#### Issue 1 — FR names must match exactly

Every method in the class diagram must use the **exact same name** as the functional requirement listed in Phase 1. The names are:

| UC | Method name to use |
|---|---|
| UC-01 | `manageInventory()` |
| UC-02 | `assignCourier()` |
| UC-03 | `manageProfile()` |
| UC-04 | `trackOrderStatus()` |
| UC-05 | `manageOrder()` |

Place each method in the class that logically owns it:
- `manageInventory()` and `assignCourier()` → `Administrator`
- `manageProfile()` → `Customer`
- `trackOrderStatus()` → `Customer` (or `Order`)
- `manageOrder()` → `Customer`

#### Issue 2 — Add relation names on all arrows

Every association line must have a label. Use these:

| From | Arrow label | To |
|---|---|---|
| Customer | "places" | Order |
| Administrator | "manages" | Inventory |
| Inventory | "tracks" | Medicine |
| Administrator | "assigns courier to" | Order |
| Courier | "handles" | Order |
| Order | "includes" | Payment |

#### Issue 3 — Order ◆ Payment must be Composition

Draw a **filled diamond** on the `Order` side pointing to `Payment`.  
Reason: a Payment only exists because of an Order — they live and die together.  
Multiplicity: `Order 1 ◆──── 1 Payment`

#### Issue 4 — DeliveryAddress, OrderItem, TrackingInfo are NOT classes

Remove them as standalone class boxes. Absorb their attributes:

| Was a class | Absorbed into | Fields to add |
|---|---|---|
| `DeliveryAddress` | `Customer` | `address: String`, `city: String`, `country: String` |
| `TrackingInfo` | `Order` | `currentStatus: String`, `lastUpdated: Date` |
| `OrderItem` | DB table only (not a Java class) | — |

`OrderItem` still exists as a table in the database (for normalization), but you do **not** need a Java class for it. Orders can carry a list of medicine IDs internally.

#### Issue 5 — Add Inventory class

`Inventory` was completely missing. Add it as a class that manages stock for medicines. See full design in Part 2.

#### Issue 6 — Add Staff (The Big Question — Answered Below)

See **Part 2 — Updated Design** for the full explanation.

#### Issue 7 — Remove arrowhead shape/direction on associations

Association lines between classes (not inheritance) should be plain lines with a label. No arrowheads. Only use:
- **Hollow triangle (△)** for inheritance/generalisation
- **Filled diamond (◆)** for composition
- **Hollow diamond (◇)** for aggregation
- Plain line for regular association

---

### 1.3 Activity Diagrams — Per Person

> [!info] Core Rule for ALL activity diagrams
> Pick **ONE perspective only**. Remove the second swimlane. Show only what the **actor** does as a decision flowchart, not what the system does internally.

| Member | UC | Problem | Fix |
|---|---|---|---|
| Yosef Gad | UC-03 | Two lanes: Customer & System | Remove System lane. Redraw as single-lane flowchart from **Customer's perspective only** |
| Yousef Mohiey | UC-05 | Missing join bar at the end | Add a **synchronisation/join bar** before the single end node — the three branches (Place / Modify / Cancel) must merge into it |
| Yousif Hafez | UC-04 | Multiple end nodes (filled circles) | All paths must flow into exactly **one** end node — merge the error path and success path before terminating |
| Youssef Adel | UC-01 | Two lanes: Admin & System/Database | Remove System/Database lane. Redraw from **Admin's perspective only** |
| Tarek Saeed | UC-02 | No feedback — no change needed | ✓ Already correct |

**How to fix Yousef Mohiey's join bar:**  
After the three branches each reach their `Send confirmation` step, draw lines from all three into a horizontal join bar (thick horizontal line), then one line from the bar to the single end node.

**How to fix Yousif Hafez's end nodes:**  
The error path (`Display retrieval error message`) currently goes to its own end node. Instead, after showing the error, loop it back to `Select order to track` or merge it into the one final end node.

---

### 1.4 Sequence Diagrams — Per Person

| Member | UC | Problem | Fix |
|---|---|---|---|
| All | All | Diagrams missing functionality name in title | Every diagram title must say the full name, e.g. *"Sequence Diagram — Manage Order (UC-05)"* |
| Yousef Mohiey | UC-05 | `alt` frame only covers `:Order` and `:Payment` boxes | Stretch the `alt` frame leftward so it covers **all lifelines**: Customer, CustomerInterface, OrderController, Order, Payment |
| Yousif Hafez | UC-04 | Customer lifeline has no activation bar | Draw the thick black activation rectangle on the `Customer` lifeline for the entire duration of the interaction |
| Others | — | No feedback | ✓ Already correct |

---

## Part 2 — Updated Class Design

### 2.1 The Staff Question — Full Explanation

The feedback says "you might need class Staff." Here is the reasoning and the correct solution:

**Problem with the old design:**
`Administrator` and `Courier` were drawn as separate, unrelated classes. But they share many attributes: ID, name, email, password, phone number, availability. This is repetition.

**Solution — Abstract `Staff` class:**

```
Staff  (abstract)
├── Administrator
└── Courier

Customer  (completely separate — customers are not staff)
```

**Why abstract?**  
You never create a plain `Staff` object. You always create either an `Administrator` or a `Courier`. Making it abstract enforces that.

**In the database**, one `STAFF` table handles both. A `role` column (`'ADMIN'` or `'COURIER'`) distinguishes them. Login works the same for both — they enter email + password, the system reads the role, and opens the correct dashboard.

**In the GUI:**
- Admin logs in → sees: *Manage Inventory* panel and *Assign Courier* panel
- Courier logs in → sees: *View Assignments* panel and *Confirm Delivery* button
- Customer logs in → sees: *Manage Order*, *Track Order*, *Manage Profile*

---

### 2.2 Complete Corrected Class Definitions

#### `Customer`

```
- customerId : String
- name       : String
- email      : String
- password   : String
- phoneNumber: String
- address    : String        ← absorbed from DeliveryAddress
- city       : String        ← absorbed from DeliveryAddress
- country    : String        ← absorbed from DeliveryAddress

+ login()           : boolean
+ manageProfile()   : void
+ manageOrder()     : void
+ trackOrderStatus(): void
+ validateProfile() : boolean
+ getOrders()       : List<Order>
```

---

#### `Staff`  *(abstract)*

```
- staffId    : String
- name       : String
- email      : String
- password   : String
- phoneNumber: String
- isAvailable: boolean

+ login(): boolean
```

---

#### `Administrator`  *(extends Staff)*

```
+ manageInventory(): void
+ assignCourier()  : void
+ updateOrderStatus(): void
```

No extra attributes — everything is in `Staff`.

---

#### `Courier`  *(extends Staff)*

```
- assignedOrders: List<Order>

+ viewAssignment()   : List<Order>
+ confirmDelivery()  : void
+ checkAvailability(): boolean
```

---

#### `Medicine`

```
- medicineId  : String
- medicineName: String
- price       : double
- description : String

+ getDetails(): void
```

---

#### `Inventory`  *(new — was missing)*

```
- inventoryId : String
- medicineId  : String
- stockLevel  : int
- reorderLevel: int

+ manageInventory()          : void
+ updateStock(newQty: int)   : void
+ updatePrice(newPrice: double): void
+ search(query: String)      : List<Medicine>
+ addMedicine(m: Medicine)   : void
+ calculateReorder()         : boolean
```

Relationship: `Administrator "manages" 1 Inventory`, `Inventory "tracks" 1..* Medicine`

---

#### `Order`

```
- orderId        : String
- customerId     : String
- courierId      : String
- orderDate      : Date
- status         : OrderStatus
- totalAmount    : double
- deliveryAddress: String        ← absorbed from DeliveryAddress
- estimatedDelivery: Date
- currentStatus  : String        ← absorbed from TrackingInfo
- lastUpdated    : Date          ← absorbed from TrackingInfo

+ placeOrder()               : boolean
+ cancelOrder()              : boolean
+ modifyOrder()              : boolean
+ assignCourier(id: String)  : boolean
+ getStatus()                : OrderStatus
```

---

#### `Payment`

```
- paymentId    : String
- orderId      : String
- customerId   : String
- amount       : double
- method       : String
- status       : PaymentStatus
- paymentDate  : Date
- transactionId: String

+ processPayment(): boolean
+ refund()        : boolean
+ getReceipt()    : String
+ getStatus()     : PaymentStatus
```

---

#### Enumerations

```
<<enumeration>> OrderStatus
  PENDING
  CONFIRMED
  OUT_FOR_DELIVERY
  DELIVERED
  CANCELLED

<<enumeration>> PaymentStatus
  PENDING
  SUCCESS
  FAILED
  REFUNDED
```

---

### 2.3 Relationships Summary for Class Diagram

| From | Type | To | Label | Multiplicity |
|---|---|---|---|---|
| Customer | Association | Order | "places" | 1 → 0..* |
| Order | Composition ◆ | Payment | "includes" | 1 → 1 |
| Administrator | Association | Inventory | "manages" | 1 → 1 |
| Inventory | Association | Medicine | "tracks" | 1 → 1..* |
| Administrator | Association | Order | "assigns courier to" | 1 → 0..* |
| Courier | Association | Order | "handles" | 0..1 → 0..* |
| Staff | Generalisation △ | Administrator | — | — |
| Staff | Generalisation △ | Courier | — | — |

**Reminder:** Arrow shape rule — associations = plain line + label. Inheritance = hollow triangle. Composition = filled diamond on the "owner" side.

---

## Part 3 — Derby Database Schema

> [!important]
> - `ORDER` is a **reserved keyword** in Derby SQL. Use `ORDER_TABLE` instead.
> - Database name: `pharmacy` | Username: `bue` | Password: `bue`
> - Start Derby Server first: right-click Java DB → Start Server
> - Add Java DB Driver to project: Project → Properties → Libraries → Add Library → Java DB Driver

```sql
CREATE TABLE CUSTOMER (
    CUSTOMER_ID  VARCHAR(10)  PRIMARY KEY,
    NAME         VARCHAR(50)  NOT NULL,
    EMAIL        VARCHAR(50)  NOT NULL,
    PASSWORD     VARCHAR(50)  NOT NULL,
    PHONE        VARCHAR(15),
    ADDRESS      VARCHAR(100),
    CITY         VARCHAR(30),
    COUNTRY      VARCHAR(30)
);

CREATE TABLE STAFF (
    STAFF_ID     VARCHAR(10)  PRIMARY KEY,
    NAME         VARCHAR(50)  NOT NULL,
    EMAIL        VARCHAR(50)  NOT NULL,
    PASSWORD     VARCHAR(50)  NOT NULL,
    PHONE        VARCHAR(15),
    ROLE         VARCHAR(10)  NOT NULL,    -- 'ADMIN' or 'COURIER'
    IS_AVAILABLE SMALLINT     DEFAULT 1   -- 1 = available, 0 = not
);

CREATE TABLE MEDICINE (
    MEDICINE_ID  VARCHAR(10)  PRIMARY KEY,
    NAME         VARCHAR(50)  NOT NULL,
    PRICE        DOUBLE       NOT NULL,
    DESCRIPTION  VARCHAR(200),
    STOCK_LEVEL  INT          DEFAULT 0,
    REORDER_LEVEL INT         DEFAULT 10
);

CREATE TABLE ORDER_TABLE (
    ORDER_ID     VARCHAR(10)  PRIMARY KEY,
    CUSTOMER_ID  VARCHAR(10),
    COURIER_ID   VARCHAR(10),
    ORDER_DATE   DATE,
    STATUS       VARCHAR(20),             -- PENDING / CONFIRMED / OUT_FOR_DELIVERY / DELIVERED / CANCELLED
    TOTAL_AMOUNT DOUBLE,
    ADDRESS      VARCHAR(100),
    CITY         VARCHAR(30),
    COUNTRY      VARCHAR(30),
    LAST_UPDATED DATE,
    FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMER(CUSTOMER_ID),
    FOREIGN KEY (COURIER_ID)  REFERENCES STAFF(STAFF_ID)
);

CREATE TABLE ORDER_ITEM (
    ORDER_ID     VARCHAR(10),
    MEDICINE_ID  VARCHAR(10),
    QUANTITY     INT,
    UNIT_PRICE   DOUBLE,
    PRIMARY KEY (ORDER_ID, MEDICINE_ID),
    FOREIGN KEY (ORDER_ID)    REFERENCES ORDER_TABLE(ORDER_ID),
    FOREIGN KEY (MEDICINE_ID) REFERENCES MEDICINE(MEDICINE_ID)
);

CREATE TABLE PAYMENT (
    PAYMENT_ID     VARCHAR(10)  PRIMARY KEY,
    ORDER_ID       VARCHAR(10),
    AMOUNT         DOUBLE,
    METHOD         VARCHAR(20),
    STATUS         VARCHAR(10),           -- PENDING / SUCCESS / FAILED
    PAYMENT_DATE   DATE,
    TRANSACTION_ID VARCHAR(20),
    FOREIGN KEY (ORDER_ID) REFERENCES ORDER_TABLE(ORDER_ID)
);
```

---

### Shared DB Connection Helper

Create this once and every member imports it:

```java
// DBConnection.java
import java.sql.*;

public class DBConnection {
    private static final String URL  = "jdbc:derby://localhost:1527/pharmacy";
    private static final String USER = "bue";
    private static final String PASS = "bue";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
```

---

## Part 4 — Implementation Guide Per Member

### Member 1 — Youssef Adel (Manage Inventory, UC-01)

**What the GUI must do:**
1. Search for a medicine by name → show results in a JTable
2. Select a row → edit stock level or price → click Save
3. If medicine not found → show "Add Medicine" form → fill all fields → click Add

**Java classes to create:**
- `Medicine.java` — plain Java object (fields + getters/setters)
- `InventoryDAO.java` — all DB operations (DAO = Data Access Object)
- `ManageInventoryFrame.java` — JFrame GUI

**Key DB queries:**

```java
// Search medicine
String sql = "SELECT * FROM MEDICINE WHERE NAME LIKE ?";
ps.setString(1, "%" + searchText + "%");

// Update stock
String sql = "UPDATE MEDICINE SET STOCK_LEVEL = ? WHERE MEDICINE_ID = ?";
ps.setInt(1, newQty);
ps.setString(2, medicineId);

// Update price
String sql = "UPDATE MEDICINE SET PRICE = ? WHERE MEDICINE_ID = ?";
ps.setDouble(1, newPrice);
ps.setString(2, medicineId);

// Add new medicine
String sql = "INSERT INTO MEDICINE VALUES (?, ?, ?, ?, ?, ?)";
```

**Exception handling pattern:**

```java
private void updateStock(String medicineId, int newQty) {
    String sql = "UPDATE MEDICINE SET STOCK_LEVEL = ? WHERE MEDICINE_ID = ?";
    try {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, newQty);
        ps.setString(2, medicineId);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Inventory updated successfully");
        ps.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to save: " + e.getMessage());
    }
}
```

---

### Member 2 — Tarek Saeed (Assign Courier, UC-02)

**What the GUI must do:**
1. Load and show all PENDING orders in a JTable
2. Load and show all available couriers (IS_AVAILABLE = 1) in a second JTable
3. Admin selects one order + one courier → clicks Assign → order status changes to CONFIRMED, courier marked unavailable

**Java classes to create:**
- `Staff.java` — base class (or abstract)
- `Administrator.java` — extends Staff (or just use it directly)
- `Courier.java` — model for displaying courier data
- `AssignCourierFrame.java` — JFrame GUI

**Key DB queries:**

```java
// Load pending orders
String sql = "SELECT O.ORDER_ID, C.NAME, O.ADDRESS, O.ORDER_DATE "
           + "FROM ORDER_TABLE O JOIN CUSTOMER C ON O.CUSTOMER_ID = C.CUSTOMER_ID "
           + "WHERE O.STATUS = 'PENDING'";

// Load available couriers
String sql = "SELECT STAFF_ID, NAME, PHONE FROM STAFF "
           + "WHERE ROLE = 'COURIER' AND IS_AVAILABLE = 1";

// Assign courier to order
String sql = "UPDATE ORDER_TABLE SET COURIER_ID = ?, STATUS = 'CONFIRMED', "
           + "LAST_UPDATED = CURRENT_DATE WHERE ORDER_ID = ?";

// Mark courier as unavailable after assignment
String sql = "UPDATE STAFF SET IS_AVAILABLE = 0 WHERE STAFF_ID = ?";
```

**Exception handling pattern:**

```java
private void assignCourier(String orderId, String courierId) {
    try {
        Connection conn = DBConnection.getConnection();

        String sql1 = "UPDATE ORDER_TABLE SET COURIER_ID = ?, STATUS = 'CONFIRMED', "
                    + "LAST_UPDATED = CURRENT_DATE WHERE ORDER_ID = ?";
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ps1.setString(1, courierId);
        ps1.setString(2, orderId);
        ps1.executeUpdate();

        String sql2 = "UPDATE STAFF SET IS_AVAILABLE = 0 WHERE STAFF_ID = ?";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setString(1, courierId);
        ps2.executeUpdate();

        JOptionPane.showMessageDialog(this, "Courier assigned successfully");
        ps1.close(); ps2.close(); conn.close();
        loadPendingOrders(); // refresh the table
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Assignment failed: " + e.getMessage());
    }
}
```

---

### Member 3 — Yosef Osama Gad (Manage Profile, UC-03)

**What the GUI must do:**
1. Load and display current customer profile (read-only labels)
2. Click Edit → fields become editable JTextFields
3. User changes data → clicks Save → validate → update DB
4. Show success confirmation or error message

**Java classes to create:**
- `Customer.java` — model
- `ManageProfileFrame.java` — JFrame GUI

**Key DB queries:**

```java
// Load profile (customerId would come from a login session variable)
String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";

// Update profile
String sql = "UPDATE CUSTOMER SET NAME=?, EMAIL=?, PHONE=?, "
           + "ADDRESS=?, CITY=?, COUNTRY=? WHERE CUSTOMER_ID=?";
```

**Validation before saving:**

```java
private boolean validateFields() {
    if (nameField.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Name cannot be empty");
        return false;
    }
    if (!emailField.getText().contains("@")) {
        JOptionPane.showMessageDialog(this, "Enter a valid email");
        return false;
    }
    return true;
}
```

**Exception handling pattern:**

```java
private void saveProfile(String customerId) {
    if (!validateFields()) return;  // validate first, before touching DB

    String sql = "UPDATE CUSTOMER SET NAME=?, EMAIL=?, PHONE=?, "
               + "ADDRESS=?, CITY=?, COUNTRY=? WHERE CUSTOMER_ID=?";
    try {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nameField.getText().trim());
        ps.setString(2, emailField.getText().trim());
        ps.setString(3, phoneField.getText().trim());
        ps.setString(4, addressField.getText().trim());
        ps.setString(5, cityField.getText().trim());
        ps.setString(6, countryField.getText().trim());
        ps.setString(7, customerId);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Profile updated successfully");
        ps.close();
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error saving profile: " + e.getMessage());
    }
}
```

---

### Member 4 — Yousif Hafez (Track Order Status, UC-04)

**What the GUI must do:**
1. Load all orders for the logged-in customer → show in a JTable (orderId, status, date)
2. Customer selects an order → bottom panel shows full status details
3. Refresh button → re-queries DB to show latest status

**Java classes to create:**
- `Order.java` — model (only status-relevant fields needed)
- `TrackOrderFrame.java` — JFrame GUI

**Key DB queries:**

```java
// Load all orders for a customer
String sql = "SELECT ORDER_ID, STATUS, ORDER_DATE, LAST_UPDATED, ADDRESS "
           + "FROM ORDER_TABLE WHERE CUSTOMER_ID = ? ORDER BY ORDER_DATE DESC";

// Load details for one selected order
String sql = "SELECT * FROM ORDER_TABLE WHERE ORDER_ID = ?";
```

**Exception handling pattern:**

```java
private void loadOrders(String customerId) {
    String sql = "SELECT ORDER_ID, STATUS, ORDER_DATE, LAST_UPDATED "
               + "FROM ORDER_TABLE WHERE CUSTOMER_ID = ?";
    try {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, customerId);
        ResultSet rs = ps.executeQuery();

        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.setRowCount(0); // clear existing rows
        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getString("ORDER_ID"),
                rs.getString("STATUS"),
                rs.getDate("ORDER_DATE"),
                rs.getDate("LAST_UPDATED")
            });
        }
        rs.close(); ps.close(); conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Could not load orders: " + e.getMessage());
    }
}
```

---

### Member 5 — Yousef Mohiey (Manage Order, UC-05)

**What the GUI must do:**
1. Three buttons at top: Place Order / Modify Order / Cancel Order
2. **Place:** Show medicine list → user picks items + quantities + address → confirm → insert to DB + payment record
3. **Modify:** Load pending orders → select one → change quantities → save
4. **Cancel:** Load pending orders → select one → confirm cancel → update status

**Java classes to create:**
- `Order.java` — model
- `Payment.java` — model
- `ManageOrderFrame.java` — JFrame GUI

**Key DB queries:**

```java
// Place order — insert order record
String sql = "INSERT INTO ORDER_TABLE (ORDER_ID, CUSTOMER_ID, ORDER_DATE, STATUS, TOTAL_AMOUNT, ADDRESS) "
           + "VALUES (?, ?, CURRENT_DATE, 'PENDING', ?, ?)";

// Place order — insert each order item
String sql = "INSERT INTO ORDER_ITEM (ORDER_ID, MEDICINE_ID, QUANTITY, UNIT_PRICE) VALUES (?, ?, ?, ?)";

// Place order — insert payment
String sql = "INSERT INTO PAYMENT (PAYMENT_ID, ORDER_ID, AMOUNT, METHOD, STATUS, PAYMENT_DATE) "
           + "VALUES (?, ?, ?, 'CARD', 'SUCCESS', CURRENT_DATE)";

// Modify — check status first (only PENDING can be modified)
String sql = "SELECT STATUS FROM ORDER_TABLE WHERE ORDER_ID = ?";

// Modify — update item quantity
String sql = "UPDATE ORDER_ITEM SET QUANTITY = ? WHERE ORDER_ID = ? AND MEDICINE_ID = ?";

// Cancel
String sql = "UPDATE ORDER_TABLE SET STATUS = 'CANCELLED', LAST_UPDATED = CURRENT_DATE "
           + "WHERE ORDER_ID = ? AND STATUS = 'PENDING'";
```

**Exception handling pattern — Place Order (use a transaction):**

```java
private void placeOrder(String customerId, String address, double total) {
    Connection conn = null;
    try {
        conn = DBConnection.getConnection();
        conn.setAutoCommit(false);  // begin transaction

        String orderId = "ORD" + System.currentTimeMillis();
        String sql1 = "INSERT INTO ORDER_TABLE VALUES (?, ?, NULL, CURRENT_DATE, 'PENDING', ?, ?, NULL, NULL, CURRENT_DATE)";
        PreparedStatement ps1 = conn.prepareStatement(sql1);
        ps1.setString(1, orderId);
        ps1.setString(2, customerId);
        ps1.setDouble(3, total);
        ps1.setString(4, address);
        ps1.executeUpdate();

        // insert order items here in a loop ...

        String payId = "PAY" + System.currentTimeMillis();
        String sql2 = "INSERT INTO PAYMENT VALUES (?, ?, ?, 'CARD', 'SUCCESS', CURRENT_DATE, ?)";
        PreparedStatement ps2 = conn.prepareStatement(sql2);
        ps2.setString(1, payId);
        ps2.setString(2, orderId);
        ps2.setDouble(3, total);
        ps2.setString(4, payId);
        ps2.executeUpdate();

        conn.commit();  // all good — commit
        JOptionPane.showMessageDialog(this, "Order placed successfully. Order ID: " + orderId);

    } catch (SQLException e) {
        try { if (conn != null) conn.rollback(); } catch (SQLException ignored) {}
        JOptionPane.showMessageDialog(this, "Order failed: " + e.getMessage());
    } finally {
        try { if (conn != null) { conn.setAutoCommit(true); conn.close(); } }
        catch (SQLException ignored) {}
    }
}

// Status check before modify/cancel
private boolean isOrderPending(String orderId) {
    String sql = "SELECT STATUS FROM ORDER_TABLE WHERE ORDER_ID = ?";
    try {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, orderId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return "PENDING".equals(rs.getString("STATUS"));
        }
        rs.close(); ps.close(); conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Could not check order status: " + e.getMessage());
    }
    return false;
}
```

---

## Part 5 — Simple GUI Template

Every member's JFrame should follow this pattern. Keep it simple — no external libraries.

```java
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class ManageInventoryFrame extends JFrame {

    private JTextField searchField;
    private JTable     resultTable;
    private DefaultTableModel tableModel;
    private JButton    searchBtn, saveBtn;

    public ManageInventoryFrame() {
        setTitle("Manage Inventory — UC-01");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        buildUI();
        loadAllMedicines();  // populate table on open
    }

    private void buildUI() {
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchField = new JTextField(20);
        searchBtn   = new JButton("Search");
        top.add(new JLabel("Medicine Name:"));
        top.add(searchField);
        top.add(searchBtn);

        tableModel  = new DefaultTableModel(
            new String[]{"ID", "Name", "Price", "Stock"}, 0);
        resultTable = new JTable(tableModel);

        saveBtn = new JButton("Save Changes");

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(resultTable), BorderLayout.CENTER);
        add(saveBtn, BorderLayout.SOUTH);

        searchBtn.addActionListener(e -> searchMedicine(searchField.getText()));
        saveBtn.addActionListener(e -> saveSelectedRow());
    }

    private void loadAllMedicines() {
        // SELECT * FROM MEDICINE — fill tableModel
    }

    private void searchMedicine(String query) {
        // SELECT ... WHERE NAME LIKE ... — fill tableModel
    }

    private void saveSelectedRow() {
        // UPDATE ... — try/catch required
    }
}
```

> [!tip] Useful Swing components
> `JTable` + `DefaultTableModel` for grid data | `JOptionPane.showMessageDialog` for alerts | `JTextField`, `JLabel`, `JButton` for forms | `JScrollPane` wrapping `JTable` | `BorderLayout` or `GridLayout` for positioning

---

## Part 6 — Report Structure for Submission

The final document must follow this exact order in **one file**:

```
1. Cover Page  (Group 39, Phase 3, all member names and IDs)
2. Table of Contents
3. ── PHASE 1 (corrected) ──────────────────────────────────
   - Contribution Table
   - Project Description
   - Functional Requirements (5 FRs)
   - Non-Functional Requirements
   - Context Diagram
   - Use Case Diagram
   - Use Case Scenarios (5 — one per member)
4. ── PHASE 2 (corrected) ──────────────────────────────────
   - Contribution Table
   - Class Diagram (with ALL 7 fixes applied)
   - Activity Diagrams (5 — corrected per feedback)
   - Sequence Diagrams (5 — corrected per feedback)
5. ── PHASE 3 ───────────────────────────────────────────────
   - Contribution Table
   - DB Schema (CREATE TABLE statements or ER description)
   - Per member: brief explanation + GUI screenshots
```

---

## Quick Checklist Before Submission

- [ ] All Phase 1 & 2 content is in ONE document, not split
- [ ] Class diagram has `Inventory` class added
- [ ] Class diagram has `Staff` (abstract) with `Administrator` and `Courier` inheriting
- [ ] `DeliveryAddress`, `OrderItem`, `TrackingInfo` removed as class boxes
- [ ] All association arrows have labels
- [ ] `Order ◆── Payment` composition shown
- [ ] Activity diagrams: each shows only ONE perspective (no dual swimlanes)
- [ ] Yousef Mohiey's activity diagram has join bar before end node
- [ ] Yousif Hafez's activity diagram has exactly ONE end node
- [ ] Sequence diagram titles all include functionality name + UC number
- [ ] Yousef Mohiey's `alt` frame spans ALL lifelines
- [ ] Yousif Hafez's `Customer` lifeline has activation bar
- [ ] Every member's code has `try/catch` around every DB call
- [ ] `ORDER_TABLE` used (not `ORDER`) in all SQL
- [ ] Java DB Driver added to project libraries
- [ ] Derby server started before running
- [ ] GUI screenshots captured and in report
