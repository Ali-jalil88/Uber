package com.java.tutorial.entities;

import java.util.Objects;

public class Order  {
    private long id;
    private int fromId;
    private int toId;
    private Status status;
    private String orderDate;
    private int clientId;
    private int taxiId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getToId() {
        return toId;
    }

    public void setToId(int toId) {
        this.toId = toId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id &&
                fromId == order.fromId &&
                toId == order.toId &&
                clientId == order.clientId &&
                taxiId == order.taxiId &&
                status == order.status &&
                Objects.equals(orderDate, order.orderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fromId, toId, status, orderDate, clientId, taxiId);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", fromId=" + fromId +
                ", toId=" + toId +
                ", status=" + status +
                ", orderDate='" + orderDate + '\'' +
                ", clientId=" + clientId +
                ", taxiId=" + taxiId +
                '}';
    }
}
