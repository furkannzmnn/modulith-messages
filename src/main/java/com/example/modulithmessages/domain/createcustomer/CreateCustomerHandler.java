package com.example.modulithmessages.domain.createcustomer;

import com.example.modulithmessages.model.Customer;
import com.example.modulithmessages.repository.CustomerRepository;
import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import io.craftgate.modulith.messaging.api.annotation.MessageHandlerConfig;
import io.craftgate.modulith.messaging.api.handler.MessageHandler;

@DomainComponent
@MessageHandlerConfig(selector = CreateCustomerUseCase.class, isChained = true, isTransactional = true)
public class CreateCustomerHandler extends MessageHandler<CreateCustomerUseCase, Customer> {

        private final CustomerRepository customerRepository;

        public CreateCustomerHandler(CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
        }

        public Customer handle(CreateCustomerUseCase message) {
            Customer customer = Customer.create(message);
            customerRepository.save(customer);
            customer.doNotify();
            return customer;
        }
}
