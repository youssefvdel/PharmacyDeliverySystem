-- Test Data for Pharmacy Delivery System
-- Run after schema.sql

-- Staff
INSERT INTO Staff VALUES ('S001', 'Admin User', 'admin@pharmacy.com', 'admin123', 'Admin');
INSERT INTO Staff VALUES ('S002', 'John Courier', 'john@pharmacy.com', 'courier123', 'Courier');
INSERT INTO Staff VALUES ('S003', 'Sarah Courier', 'sarah@pharmacy.com', 'courier456', 'Courier');

-- Administrators
INSERT INTO Administrator VALUES ('A001', 'S001');

-- Couriers
INSERT INTO Courier (courierId, staffId, courierName, phoneNumber, isAvailable, currentLocation, deliveryArea) 
VALUES ('C001', 'S002', 'John Courier', '01001234567', true, 'Cairo', 'Downtown');
INSERT INTO Courier (courierId, staffId, courierName, phoneNumber, isAvailable, currentLocation, deliveryArea) 
VALUES ('C002', 'S003', 'Sarah Courier', '01007654321', true, 'Cairo', 'Nasr City');

-- Customers
INSERT INTO Customer VALUES ('CU001', 'Youssef Adel', 'youssef@email.com', 'pass123', '01001112233', '123 Main St, Cairo');
INSERT INTO Customer VALUES ('CU002', 'Tarek Saeed', 'tarek@email.com', 'pass456', '01002223344', '456 Oak St, Cairo');

-- Medicines
INSERT INTO Medicine (name, category, price, stockQuantity, expiryDate, description) 
VALUES ('Panadol', 'Pain Relief', 25.0, 100, '2026-12-31', 'Paracetamol 500mg');
INSERT INTO Medicine (name, category, price, stockQuantity, expiryDate, description) 
VALUES ('Augmentin', 'Antibiotic', 85.0, 50, '2026-10-15', 'Amoxicillin 1g');
INSERT INTO Medicine (name, category, price, stockQuantity, expiryDate, description) 
VALUES ('Vitamin C', 'Vitamins', 35.0, 200, '2027-06-30', 'Vitamin C 1000mg');
INSERT INTO Medicine (name, category, price, stockQuantity, expiryDate, description) 
VALUES ('Insulin', 'Diabetes', 150.0, 20, '2026-08-20', 'Insulin injection');

-- Inventory
INSERT INTO Inventory (medicineId, stockLevel, price, expiryDate) VALUES (1, 100, 25.0, '2026-12-31');
INSERT INTO Inventory (medicineId, stockLevel, price, expiryDate) VALUES (2, 50, 85.0, '2026-10-15');
INSERT INTO Inventory (medicineId, stockLevel, price, expiryDate) VALUES (3, 200, 35.0, '2027-06-30');
INSERT INTO Inventory (medicineId, stockLevel, price, expiryDate) VALUES (4, 20, 150.0, '2026-08-20');

-- Orders
INSERT INTO OrderTable (orderId, customerId, priority, totalAmount, status, deliveryAddress, courierId) 
VALUES ('O001', 'CU001', 'High', 110.0, 'Pending', '123 Main St, Cairo', NULL);
INSERT INTO OrderTable (orderId, customerId, priority, totalAmount, status, deliveryAddress, courierId) 
VALUES ('O002', 'CU002', 'Medium', 35.0, 'Pending', '456 Oak St, Cairo', NULL);

-- OrderItems
INSERT INTO OrderItem (orderId, medicineId, quantity, price) VALUES ('O001', 1, 2, 50.0);
INSERT INTO OrderItem (orderId, medicineId, quantity, price) VALUES ('O001', 2, 1, 85.0);
INSERT INTO OrderItem (orderId, medicineId, quantity, price) VALUES ('O002', 3, 1, 35.0);

-- Payments
INSERT INTO Payment (paymentId, orderId, amount, method, status) 
VALUES ('P001', 'O001', 110.0, 'Cash', 'Pending');
INSERT INTO Payment (paymentId, orderId, amount, method, status) 
VALUES ('P002', 'O002', 35.0, 'CreditCard', 'Pending');
