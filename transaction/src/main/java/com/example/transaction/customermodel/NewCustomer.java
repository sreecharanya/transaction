package com.example.transaction.customermodel;

public class NewCustomer {

    private String customerName;
    private String month;
    private int points;
    private double amount;

    public NewCustomer(String customerName, String month, int points, double amount) {
        this.customerName = customerName;
        this.month = month;
        this.points = points;
        this.amount = amount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}


