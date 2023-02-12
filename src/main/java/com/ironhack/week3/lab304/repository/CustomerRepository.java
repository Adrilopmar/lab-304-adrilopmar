package com.ironhack.week3.lab304.repository;

import com.ironhack.week3.lab304.Model.Customer;
import com.ironhack.week3.lab304.Model.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByNameLike(String name);
    Customer findByStatus(CustomerStatus status);

}
