package br.edu.ifpb.uploadservice.event;

import br.edu.ifpb.producer.events.ConteudoInicializado;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.service.ReservaEspacoService;
import br.edu.ifpb.uploadservice.service.erros.NenhumaUnidadeComEspacoDisponivelException;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class EventConsumerHandler {

    private String aggregateType;

    @Autowired
    private ReservaEspacoService reservaEspacoService;

    public EventConsumerHandler(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public DomainEventHandlers domainEventHandlers() {
        return DomainEventHandlersBuilder
                .forAggregateType(aggregateType)
                .onEvent(ConteudoInicializado.class, this::tratarConteudoInicializado)
                .build();
    }

    public void tratarConteudoInicializado(DomainEventEnvelope<ConteudoInicializado> event) {
        try {
            ReservaEspaco reservaEspaco = reservaEspacoService.efetuarReservaDeEspaco(event.getEvent().getTamanho());
            //Gerar evento de reserva de espaço iniciada
        } catch (NenhumaUnidadeComEspacoDisponivelException e) {

        }

    }

}
