package br.edu.ifpb.producer.events;

import io.eventuate.tram.events.common.DomainEvent;

public class ReservaEspacoEfetuada implements DomainEvent {

    public ReservaEspacoEfetuada() {
    }

    public ReservaEspacoEfetuada(String codigoReserva, Long conteudoId) {
        this.codigoReserva = codigoReserva;
        this.conteudoId = conteudoId;
    }

    private String codigoReserva;
    private Long conteudoId;

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public void setCodigoReserva(String codigoReserva) {
        this.codigoReserva = codigoReserva;
    }

    public Long getConteudoId() {
        return conteudoId;
    }

    public void setConteudoId(Long conteudoId) {
        this.conteudoId = conteudoId;
    }
}
