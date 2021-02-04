package com.java.tutorial.entities;

import java.util.Objects;

public class Address {
    private long id;
    private String nameStreet;
    private int numberStreet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    public int getNumberStreet() {
        return numberStreet;
    }

    public void setNumberStreet(int numberStreet) {
        this.numberStreet = numberStreet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id &&
                numberStreet == address.numberStreet &&
                Objects.equals(nameStreet, address.nameStreet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameStreet, numberStreet);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", nameStreet='" + nameStreet + '\'' +
                ", numberStreet=" + numberStreet +
                '}';
    }


}
