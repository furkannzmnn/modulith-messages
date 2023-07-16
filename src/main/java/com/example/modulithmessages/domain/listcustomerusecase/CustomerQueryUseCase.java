package com.example.modulithmessages.domain.listcustomerusecase;


import com.example.modulithmessages.model.Customer;
import io.craftgate.modulith.messaging.api.model.Message;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import static io.craftgate.modulith.messaging.api.MessagePublisher.publishAndGet;

@Getter
@Setter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class CustomerQueryUseCase extends Message {
    private Long id;

    public Customer publish() {
       return publishAndGet(this);
    }
}
