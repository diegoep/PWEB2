package br.edu.ifpb.producer.eventsconsumer;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConfiguration {

    @Bean
    public ReservaEspacoEventHandler reservaEspacoEventHandler() {
        return new ReservaEspacoEventHandler();
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(ReservaEspacoEventHandler reservaEspacoEventHandler, MessageConsumer messageConsumer) {
        return new DomainEventDispatcher("commandproducer", reservaEspacoEventHandler.getDomainEventHandlers(), messageConsumer);
    }

}
