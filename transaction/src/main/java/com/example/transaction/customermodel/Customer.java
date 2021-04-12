package com.example.transaction.customermodel;


import javax.persistence.*;

@Entity
@Table(name ="TRANSACTION")
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "CUSTOMER_ID")
    private long customerId;

    @Column(name = "CUSTOMER_NAME")
    private String customerName;

    @Column(name ="MONTH")
    private String month;

    @Column(name ="POINTS")
    private int points;

    @Column(name = "AMOUNT")
    private double amount;

    public Customer() {
        this.customerId = customerId;
        this.customerName = customerName;
        this.month = month;
        this.points = points;
        this.amount = amount;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerid) {
        this.customerId = customerid;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
