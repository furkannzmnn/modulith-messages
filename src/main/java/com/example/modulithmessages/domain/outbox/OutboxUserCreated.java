package com.example.modulithmessages.domain.outbox;

import io.craftgate.modulith.messaging.api.annotation.MessageType;
import io.craftgate.modulith.messaging.api.model.Message;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@MessageType(name = "USER_NOTIFIED")
@Getter
@SuperBuilder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false)
public class OutboxUserCreated extends Message {

        private String username;

        public static Message of(String username) {
            return OutboxUserCreated.builder()
                    .username(username)
                    .build();
        }
}
