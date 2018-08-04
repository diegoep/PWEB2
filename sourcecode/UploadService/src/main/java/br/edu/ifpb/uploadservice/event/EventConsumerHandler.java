package br.edu.ifpb.uploadservice.event;

import br.edu.ifpb.producer.events.ConteudoCriado;
import br.edu.ifpb.producer.events.ReservaEspacoEfetuada;
import br.edu.ifpb.producer.events.ReservaEspacoNegada;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.service.ReservaEspacoService;
import br.edu.ifpb.uploadservice.service.erros.NenhumaUnidadeComEspacoDisponivelException;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

public class EventConsumerHandler {

    private String aggregateType;

    @Autowired
    private ReservaEspacoService reservaEspacoService;

    @Autowired
    private DomainEventPublisher domainEventPublisher;

    public EventConsumerHandler(String aggregateType) {
        this.aggregateType = aggregateType;
    }

    public DomainEventHandlers domainEventHandlers() {
        return DomainEventHandlersBuilder
                .forAggregateType(aggregateType)
                .onEvent(ConteudoCriado.class, this::tratarConteudoCriado)
                .build();
    }

    public void tratarConteudoCriado(DomainEventEnvelope<ConteudoCriado> event) {
        try {
            ReservaEspaco reservaEspaco = reservaEspacoService.efetuarReservaDeEspaco(event.getEvent().getTamanho());
            ReservaEspacoEfetuada reservaEspacoEfetuada = new ReservaEspacoEfetuada(reservaEspaco.getCodigoReserva(), event.getEvent().getId());
            domainEventPublisher.publish("ReservaEspaco", "ReservaEspaco-"+reservaEspaco.getCodigoReserva(), Collections.singletonList(reservaEspacoEfetuada));
        } catch (NenhumaUnidadeComEspacoDisponivelException e) {
            ReservaEspacoNegada reservaEspacoNegada = new ReservaEspacoNegada(event.getEvent().getId());
            domainEventPublisher.publish("ReservaEspaco", "ReservaEspaco"+reservaEspacoNegada.getConteudoId(), Collections.singletonList(reservaEspacoNegada));
        }

    }

}
