package com.java.tutorial.entities;

import java.util.Objects;

public class Transaction{
    private long id;
    private StatusTransaction status;
    private String payDate;
    private double price;
    private int orderId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public StatusTransaction getStatus() {
        return status;
    }

    public void setStatus(StatusTransaction status) {
        this.status = status;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id && Double.compare(that.price, price) == 0 && orderId == that.orderId && status == that.status && Objects.equals(payDate, that.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, payDate, price, orderId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", status=" + status +
                ", payDate='" + payDate + '\'' +
                ", price=" + price +
                ", orderId=" + orderId +
                '}';
    }
}
