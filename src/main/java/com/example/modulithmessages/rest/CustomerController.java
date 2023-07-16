package com.example.modulithmessages.rest;

import com.example.modulithmessages.domain.createcustomer.CreateCustomerRequest;
import com.example.modulithmessages.domain.listcustomerusecase.CustomerQueryUseCase;
import com.example.modulithmessages.model.Customer;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody CreateCustomerRequest request) {
        Customer customer = request.toMessage().publish();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .cacheControl(CacheControl.noCache())
                .body(customer);
    }

    @GetMapping("/{id}")
    public Customer findBy(@PathVariable Long id) {
        CustomerQueryUseCase useCase = CustomerQueryUseCase.builder().id(id).build();
        return useCase.publish();
    }

}
