-- Pharmacy Delivery System - Database Schema
-- Group 39 | Derby Embedded
-- Run this script with: ij> run 'database/schema.sql';

-- Drop tables in reverse dependency order (Derby syntax)
DROP TABLE OrderItem;
DROP TABLE Payment;
DROP TABLE OrderTable;
DROP TABLE Medicine;
DROP TABLE Courier;
DROP TABLE Customer;
DROP TABLE Inventory;
DROP TABLE Administrator;
DROP TABLE Staff;

-- Staff (Abstract base class)
CREATE TABLE Staff (
    staffId VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL CHECK (role IN ('Admin', 'Courier'))
);

-- Administrator
CREATE TABLE Administrator (
    adminId VARCHAR(50) PRIMARY KEY,
    staffId VARCHAR(50) REFERENCES Staff(staffId)
);

-- Courier
CREATE TABLE Courier (
    courierId VARCHAR(50) PRIMARY KEY,
    staffId VARCHAR(50) REFERENCES Staff(staffId),
    courierName VARCHAR(100),
    phoneNumber VARCHAR(20),
    isAvailable BOOLEAN DEFAULT true,
    currentLocation VARCHAR(100),
    deliveryArea VARCHAR(100)
);

-- Customer
CREATE TABLE Customer (
    customerId VARCHAR(50) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    phone VARCHAR(20),
    address VARCHAR(255)
);

-- Medicine
CREATE TABLE Medicine (
    medicineId INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(100) NOT NULL,
    category VARCHAR(50),
    price DOUBLE NOT NULL CHECK (price >= 0),
    stockQuantity INT NOT NULL CHECK (stockQuantity >= 0),
    expiryDate DATE,
    description VARCHAR(255)
);

-- Inventory (tracks stock for each medicine)
CREATE TABLE Inventory (
    inventoryId INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    medicineId INT REFERENCES Medicine(medicineId),
    stockLevel INT NOT NULL CHECK (stockLevel >= 0),
    price DOUBLE NOT NULL CHECK (price >= 0),
    expiryDate DATE
);

-- Order (named OrderTable to avoid SQL keyword conflict)
CREATE TABLE OrderTable (
    orderId VARCHAR(50) PRIMARY KEY,
    customerId VARCHAR(50) REFERENCES Customer(customerId),
    orderDate DATE DEFAULT CURRENT_DATE,
    priority VARCHAR(20) DEFAULT 'Medium',
    totalAmount DOUBLE DEFAULT 0.0,
    status VARCHAR(50) DEFAULT 'Pending',
    deliveryAddress VARCHAR(255),
    courierId VARCHAR(50) REFERENCES Courier(courierId)
);

-- OrderItem
CREATE TABLE OrderItem (
    itemId INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    orderId VARCHAR(50) REFERENCES OrderTable(orderId) ON DELETE CASCADE,
    medicineId INT REFERENCES Medicine(medicineId),
    quantity INT NOT NULL CHECK (quantity > 0),
    price DOUBLE NOT NULL
);

-- Payment (Composition with Order - cascade delete)
CREATE TABLE Payment (
    paymentId VARCHAR(50) PRIMARY KEY,
    orderId VARCHAR(50) REFERENCES OrderTable(orderId) ON DELETE CASCADE,
    amount DOUBLE NOT NULL,
    method VARCHAR(50) DEFAULT 'Cash',
    status VARCHAR(50) DEFAULT 'Pending',
    transactionId VARCHAR(100),
    paymentDate DATE DEFAULT CURRENT_DATE
);
