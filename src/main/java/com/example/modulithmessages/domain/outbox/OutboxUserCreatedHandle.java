package com.example.modulithmessages.domain.outbox;

import io.craftgate.modulith.messaging.api.annotation.DomainComponent;
import io.craftgate.modulith.messaging.api.annotation.MessageHandlerConfig;
import io.craftgate.modulith.messaging.api.handler.VoidMessageHandler;

import static io.craftgate.modulith.messaging.api.MessagePublisher.publish;

@DomainComponent
@MessageHandlerConfig(selector = OutboxUserCreated.class, isChained = true, isTransactional = true)
public class OutboxUserCreatedHandle extends VoidMessageHandler<OutboxUserCreated> {
    @Override
    protected void handle(OutboxUserCreated outboxUserCreated) {
        System.out.println("OutboxUserCreatedHandle");
        publish("OUTBOX_COMPLETED");
    }
}
