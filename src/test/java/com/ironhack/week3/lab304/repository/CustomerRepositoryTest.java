package com.ironhack.week3.lab304.repository;

import com.ironhack.week3.lab304.Model.Customer;
import com.ironhack.week3.lab304.Model.CustomerStatus;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository customerRepository;
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("Agustine Riviera", CustomerStatus.SILVER);
        customerRepository.save(customer);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }
    @Test
    public void createCustomer_CorrectCustomerData_AddToDatabase(){
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
        assertTrue(optionalCustomer.isPresent());
        assertEquals(customer.getStatus(), customerRepository.findByNameLike("Agustine Riviera").getStatus());
    }
    @Test
    public void findByNameLike_ExistingClientName_ClientInDatabase(){
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
        assertTrue(optionalCustomer.isPresent());
        assertEquals(CustomerStatus.SILVER,customerRepository.findByNameLike("Agustine Riviera").getStatus());
    }
    @Test
    public void findByStatusLike_ExistingClientStatus_ClientInDatabase(){
        Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
        assertTrue(optionalCustomer.isPresent());
        assertEquals("Agustine Riviera",customerRepository.findByStatus(CustomerStatus.SILVER).getName());
    }


}