package br.edu.ifpb.producer.events;

import io.eventuate.tram.events.common.DomainEvent;

public class ConteudoCriado implements DomainEvent {

    public ConteudoCriado() {
    }

    public ConteudoCriado(Long id, long tamanho) {
        this.id = id;
        this.tamanho = tamanho;
    }

    private Long id;

    private long tamanho;

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
