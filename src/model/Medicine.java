package model;

public class Medicine {
    private int medicineId;
    private String name;
    private String category;
    private double price;
    private int stockQuantity;
    private String expiryDate;
    private String description;

    public Medicine() {}

    public Medicine(int medicineId, String name, String category, double price, int stockQuantity, String expiryDate, String description) {
        this.medicineId = medicineId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.expiryDate = expiryDate;
        this.description = description;
    }

    public void updateStock(int quantity) { this.stockQuantity = quantity; }
    public boolean updatePrice(double newPrice) {
        if (newPrice < 0) return false;
        this.price = newPrice;
        return true;
    }
    public boolean isInStock(int requestedQty) { return stockQuantity >= requestedQty; }

    public int getMedicineId() { return medicineId; }
    public void setMedicineId(int medicineId) { this.medicineId = medicineId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
