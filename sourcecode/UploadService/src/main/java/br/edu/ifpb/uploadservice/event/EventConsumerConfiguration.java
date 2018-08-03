package br.edu.ifpb.uploadservice.event;

import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventConsumerConfiguration {

    @Bean
    public EventConsumerHandler eventConsumerHandler(EventConsumerParameters eventConsumerParameters) {
        return new EventConsumerHandler(eventConsumerParameters.getAggregateType());
    }

    @Bean
    public DomainEventDispatcher domainEventDispatcher(EventConsumerParameters parameters,
                                                       EventConsumerHandler target,
                                                       MessageConsumer messageConsumer) {
        return new DomainEventDispatcher(parameters.getDispatcherId(),
                target.domainEventHandlers(),
                messageConsumer);
    }

    @Bean
    public EventConsumerParameters eventConsumerParameters() {
        return new EventConsumerParameters();
    }

}
