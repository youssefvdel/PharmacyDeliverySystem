package controllers;

import enums.OrderStatus;
import java.util.Date;
import model.Courier;
import model.Order;

public class TrackOrderController {

    public boolean placeOrder(Order order) {

        if (order.getCustomerId() == null || order.getCustomerId().isEmpty()) {
            return false;
        }

        if (order.getDeliveryAddress() == null || order.getDeliveryAddress().isEmpty()) {
            return false;
        }

        if (order.getTotalAmount() <= 0) {
            return false;
        }

        order.setStatus(OrderStatus.PENDING);
        order.setCurrentStatus("Order placed successfully. Waiting for confirmation.");
        order.setLastUpdated(new Date());

        return true;
    }

    public boolean cancelOrder(Order order) {

        if (order.getStatus() == OrderStatus.DELIVERED ||
            order.getStatus() == OrderStatus.CANCELLED) {
            return false;
        }

        order.setStatus(OrderStatus.CANCELLED);
        order.setCurrentStatus("Order cancelled by customer.");
        order.setLastUpdated(new Date());

        return true;
    }

    public boolean modifyOrder(Order order) {

        if (order.getStatus() != OrderStatus.PENDING) {
            return false;
        }

        order.setCurrentStatus("Order modified successfully.");
        order.setLastUpdated(new Date());

        return true;
    }

    public boolean assignCourier(Order order, Courier courier) {

        if (courier == null) {
            return false;
        }

        if (order.getCourier() != null) {
            return false;
        }

        if (order.getStatus() != OrderStatus.PENDING) {
            return false;
        }

        if (!courier.IsAvailable()) {
            return false;
        }

        order.setCourier(courier);
        courier.setIsAvailable(false);

        order.setStatus(OrderStatus.CONFIRMED);
        order.setCurrentStatus("Courier assigned. Order confirmed.");
        order.setLastUpdated(new Date());

        return true;
    }
}