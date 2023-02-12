package com.ironhack.week3.lab304.Model;

import jakarta.persistence.*;
@Entity

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String name;
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;

    public Customer() {
    }

    public Customer(String name, CustomerStatus status) {
        this.name = name;
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerStatus getStatus() {
        return status;
    }

    public void setStatus(CustomerStatus status) {
        this.status = status;
    }
}
