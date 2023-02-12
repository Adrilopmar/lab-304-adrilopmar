package com.ironhack.week3.lab304.repository;

import com.ironhack.week3.lab304.Model.Aircraft;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AircraftRepositoryTest {

    @Autowired
    AircraftRepository aircraftRepository;
    private Aircraft aircraft;

    @BeforeEach
    void setUp() {
        aircraft = new Aircraft("Boeing 747",1500);
        aircraftRepository.save(aircraft);
    }

    @AfterEach
   void tearDown() {
       aircraftRepository.deleteAll();
   }

    @Test
    public void createAircraft_CorrectData_AddToDataBase(){
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(aircraft.getModel());
        assertTrue(optionalAircraft.isPresent());
        assertEquals("Boeing 747",optionalAircraft.get().getModel());
    }
    @Test
    public void findByModelContaining_CorrectData_ReturnFlight(){
        Optional<Aircraft> optionalAircraft = aircraftRepository.findById(aircraft.getModel());
        assertTrue(optionalAircraft.isPresent());
        assertEquals("Boeing 747",aircraftRepository.findByModelContaining("Boeing").get(0).getModel());
    }
}