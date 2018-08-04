package br.edu.ifpb.producer.events;

import io.eventuate.tram.events.common.DomainEvent;

public class ReservaEspacoNegada implements DomainEvent {

    public ReservaEspacoNegada() {
    }

    public ReservaEspacoNegada(Long conteudoId) {
        this.conteudoId = conteudoId;
    }

    private Long conteudoId;

    public Long getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(Long conteudoId) {
        this.conteudoId = conteudoId;
    }
}
