package com.example.modulithmessages.domain.listcustomerusecase;

import com.example.modulithmessages.model.Customer;
import com.example.modulithmessages.repository.CustomerRepository;
import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import io.craftgate.modulith.messaging.api.annotation.MessageHandlerConfig;
import io.craftgate.modulith.messaging.api.handler.MessageHandler;

@DomainComponent
@MessageHandlerConfig(selector = CustomerQueryUseCase.class, isChained = true)
public class CustomerQueryHandler extends MessageHandler<CustomerQueryUseCase, Customer> {
    private final CustomerRepository customerRepository;

    public CustomerQueryHandler(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    protected Customer handle(CustomerQueryUseCase customerQueryUseCase) {
        return customerRepository.findById(customerQueryUseCase.getId()).orElse(null);
    }
}
