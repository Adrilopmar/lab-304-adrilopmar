package com.ironhack.week3.lab304.repository;

import com.ironhack.week3.lab304.Model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {
    List<Flight> findByFlightMileageGreaterThan(Long mileage);
}

