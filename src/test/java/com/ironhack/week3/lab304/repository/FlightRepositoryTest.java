package com.ironhack.week3.lab304.repository;

import com.ironhack.week3.lab304.Model.Flight;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlightRepositoryTest {
    @Autowired
    FlightRepository flightRepository;
    private Flight flight;
    private Flight flightTest;

    @BeforeEach
    void setUp() {
        flight = new Flight("DL143",125L,"Boeing 747");
        flightTest = new Flight("MJ45",600L,"Boeing 747");
        flightRepository.save(flight);
        flightRepository.save(flightTest);
    }

    @AfterEach
    void tearDown() {
        flightRepository.deleteAll();
    }
    @Test
    public void findFlightById_CorrectId_ReturnFlight(){
        Optional<Flight> optionalFlight = flightRepository.findById(flight.getFlightNumber());
        assertTrue(optionalFlight.isPresent());
        assertEquals("DL143",optionalFlight.get().getFlightNumber());
    }
        @Test
    public void createFlight_CorrectDataFlight_AddToDatabase(){
            Optional<Flight> optionalFlight = flightRepository.findById(flight.getFlightNumber());
            assertTrue(optionalFlight.isPresent());
            assertEquals("Boeing 747",optionalFlight.get().getAircraft());
    }
    @Test
    public void findByMileageGreaterThan_CorrectInput_ReturnFlights(){
        assertEquals(1,flightRepository.findByFlightMileageGreaterThan(500L).size());
    }


}