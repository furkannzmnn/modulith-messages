package com.example.modulithmessages.repository;

import com.example.modulithmessages.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
