package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;

    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int total = 0;
        for (AccountRecord charge : charges) {
            total += charge.getCharge();
        }

        //update this
        return total;
    }

    public List<AccountRecord> getCharges() {

        return charges;
    }

    public void setCharges(List<AccountRecord> charges) {
        this.charges = charges;
    }

    @Override
    public String toString() {
        //update this
        return "customer ID: " + id + ", customer Name: " + name + ", customer Balance: " + getBalance();
    }

}
