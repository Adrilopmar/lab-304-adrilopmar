package com.ironhack.week3.lab304.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Flight {
    @Id
    private String flightNumber;
    private Long flightMileage;
    private String aircraft;

    public Flight() {
    }

    public Flight(String flightNumber, Long flightMileage, String aircraft) {
        this.flightNumber = flightNumber;
        this.flightMileage = flightMileage;
        this.aircraft = aircraft;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public long getFlightMileage() {
        return flightMileage;
    }

    public void setFlightMileage(long flightMileage) {
        this.flightMileage = flightMileage;
    }

    public String getAircraft() {
        return aircraft;
    }

    public void setAircraft(String aircraft) {
        this.aircraft = aircraft;
    }
}
