package br.edu.ifpb.producer.events;

import io.eventuate.tram.events.common.DomainEvent;

public class ConteudoInicializado implements DomainEvent {

    public ConteudoInicializado() {
    }

    public ConteudoInicializado(long tamanho) {
        this.tamanho = tamanho;
    }

    private long tamanho;

    public long getTamanho() {
        return tamanho;
    }

    public void setTamanho(long tamanho) {
        this.tamanho = tamanho;
    }
}
