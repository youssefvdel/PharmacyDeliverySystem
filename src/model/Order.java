package model;

import enums.OrderStatus;
import enums.Priority;
import java.util.Date;
/**
 * Order.java
 * ---------------------------------------------
 * This class represents a customer's order in the Pharmacy Delivery System.
 * It stores all information required for tracking order status.
 * @author Yousif Hafez
 */
public class Order {

    private String orderId;
    private String customerId;
    private Courier courier;
    private String orderDate;
    private OrderStatus status;
    private double totalAmount;
    private String deliveryAddress;
    private Priority priority;
    private String estimatedDelivery;
    private String currentStatus;
    private Date lastUpdated;
    /**
     * Default constructor.
     */
    public Order() {
    }

    public Order(String orderId, String customerId, Courier courier, String orderDate,
             Priority priority, OrderStatus status, double totalAmount, String deliveryAddress,
             String estimatedDelivery, String currentStatus, java.util.Date lastUpdated) {

        this.orderId = orderId;
        this.customerId = customerId;
        this.courier = courier;
        this.orderDate = orderDate;
        this.priority = priority;
        this.status = status;
        this.totalAmount = totalAmount;
        this.deliveryAddress = deliveryAddress;
        this.estimatedDelivery = estimatedDelivery;
        this.currentStatus = currentStatus;
        this.lastUpdated = lastUpdated;
    }

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public Courier getCourier() {
            return courier;
        }

        public void setCourier(Courier courier) {
            this.courier = courier;
        }

        public String getOrderDate() {
            return orderDate;
        }

        public void setOrderDate(String orderDate) {
            this.orderDate = orderDate;
        }

        public OrderStatus getStatus() {
            return status;
        }

        public void setStatus(OrderStatus status) {
            this.status = status;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

        public String getDeliveryAddress() {
            return deliveryAddress;
        }

        public Priority getPriority() { return priority; }
        public void setPriority(Priority priority) { this.priority = priority; }

        public void setDeliveryAddress(String deliveryAddress) {
            this.deliveryAddress = deliveryAddress;
        }

        public String getEstimatedDelivery() {
            return estimatedDelivery;
        }

        public void setEstimatedDelivery(String estimatedDelivery) {
            this.estimatedDelivery = estimatedDelivery;
        }

        public String getCurrentStatus() {
            return currentStatus;
        }

        public void setCurrentStatus(String currentStatus) {
            this.currentStatus = currentStatus;
        }

        public Date getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(Date lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

    
    

    public boolean placeOrder() {

        if (customerId == null || customerId.isEmpty()) {
        return false;
        }   

        if (deliveryAddress == null || deliveryAddress.isEmpty()) {
        return false;
        }

        if (totalAmount <= 0) {
        return false;
        }

        this.status = OrderStatus.PENDING;
        this.currentStatus = "Order placed successfully. Waiting for confirmation.";
        this.lastUpdated = new java.util.Date();

        return true;
        }
    
    

    public boolean cancelOrder() {

        if (status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED) {
        return false;
        }

        this.status = OrderStatus.CANCELLED;
        this.currentStatus = "Order cancelled by customer.";
        this.lastUpdated = new java.util.Date();

        return true;
        }
    
    
    public boolean modifyOrder() {

        if (status != OrderStatus.PENDING) {
        return false;
        }

        this.currentStatus = "Order modified successfully.";
        this.lastUpdated = new java.util.Date();

        return true;
        }

    
    

    public boolean assignCourier(Courier courier) {

        if (courier == null) {
        return false;
        }

        if (this.courier != null) {
        return false;
        } 

        if (this.status != OrderStatus.PENDING) {
        return false;
        }
 
        if (!courier.IsAvailable()) {
        return false;
        }

        this.courier = courier;
         courier.setIsAvailable(false);

        this.status = OrderStatus.CONFIRMED;
        this.currentStatus = "Courier assigned. Order confirmed.";
        this.lastUpdated = new Date();

        return true;
        }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", courier=" + courier + ", orderDate=" + orderDate + ", status=" + status + ", totalAmount=" + totalAmount + ", deliveryAddress=" + deliveryAddress + ", estimatedDelivery=" + estimatedDelivery + ", currentStatus=" + currentStatus + ", lastUpdated=" + lastUpdated + '}';
    }

    }