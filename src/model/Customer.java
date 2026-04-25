package model;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * 
 * @author yosef - 255796
 */

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String password;
    private String phone;
    private String street;
    private String city;
    private String country;
    private String postalCode;
    private List<String> orderHistory;

    public Customer(String customerId, String name, String email,String password, String phone, String street, String city,String country, String postalCode)
    {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.street = street;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.orderHistory = new ArrayList<>();
    }

    public boolean login()
    {
        return true; 
    }
    public void logout() 
    { 
        System.out.println("Logged out."); 
    }

    public void updateProfile() 
    {
        System.out.println("Profile updated for: " + name);
    }

    public void displayDashboard() {
        System.out.println("Dashboard for: " + name);
    }

    // Getters

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }
  
    public List<String> getOrderHistory() {
        return orderHistory;
    }
   
    // Setters

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setOrderHistory(List<String> orderHistory) {
        this.orderHistory = orderHistory;
    }
  
}