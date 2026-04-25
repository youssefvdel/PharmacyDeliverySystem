package model;

public class Inventory {
    private int inventoryId;
    private int medicineId;
    private int stockLevel;
    private double price;
    private String expiryDate;

    public Inventory() {
    }

    public Inventory(int inventoryId, int medicineId, int stockLevel, double price, String expiryDate) {
        this.inventoryId = inventoryId;
        this.medicineId = medicineId;
        this.stockLevel = stockLevel;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public boolean updateStock(int newQty) {
        this.stockLevel = newQty;
        return true;
    }

    public boolean checkAvailability() {
        return stockLevel > 0;
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
