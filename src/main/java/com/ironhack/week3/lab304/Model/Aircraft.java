package com.ironhack.week3.lab304.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Aircraft {
    @Id
    private String model;
    private long seats;

    public Aircraft() {
    }

    public Aircraft(String model, long seats) {
        this.model = model;
        this.seats = seats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getSeats() {
        return seats;
    }

    public void setSeats(long seats) {
        this.seats = seats;
    }
}
