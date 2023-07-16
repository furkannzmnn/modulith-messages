package com.example.modulithmessages.domain.createcustomer;

import com.example.modulithmessages.model.Customer;
import io.craftgate.modulith.messaging.api.model.Message;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import static io.craftgate.modulith.messaging.api.MessagePublisher.publishAndGet;

@Getter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class CreateCustomerUseCase extends Message {
    private String username;
    private String name;
    private String surname;
    public Customer publish() {
        return publishAndGet(this);
    }
}
