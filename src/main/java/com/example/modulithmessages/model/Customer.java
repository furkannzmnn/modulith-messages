package com.example.modulithmessages.model;

import com.example.modulithmessages.domain.createcustomer.CreateCustomerUseCase;
import com.example.modulithmessages.domain.outbox.OutboxUserCreated;
import io.craftgate.modulith.messaging.api.model.AggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Customer extends AggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String username;

    public static Customer create(CreateCustomerUseCase message) {
        return Customer.of(message.getUsername(), message.getName(), message.getSurname());
    }

    public static Customer of(String username, String name, String surname) {
        return new Customer(null, username, name, surname);
    }

    public void doNotify() {
        this.registerMessage(OutboxUserCreated.of(this.getUsername()));
    }
}
