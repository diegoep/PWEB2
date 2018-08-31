package br.edu.ifpb.pweb2.cqrsspringcloud.service;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.UserUpdated;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
public class LocalEventConsumer {

    private final Processor processor;

    public LocalEventConsumer(Processor processor) {
        this.processor = processor;
    }

    @EventListener(UserUpdated.class)
    public void handleUserUpdate(UserUpdated userUpdated) {
        log.info("Enviando evento remoto!!!");
        processor.input().send(new GenericMessage<>(userUpdated));
    }


}
