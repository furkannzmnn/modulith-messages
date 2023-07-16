package com.example.modulithmessages.domain.createcustomer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {
    private String username;
    private String name;
    private String surname;

    public CreateCustomerUseCase toMessage() {
        return CreateCustomerUseCase.builder()
                .username(username)
                .name(name)
                .surname(surname)
                .build();
    }
}
