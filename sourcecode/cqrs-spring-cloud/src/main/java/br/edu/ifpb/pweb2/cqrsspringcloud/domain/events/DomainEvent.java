package br.edu.ifpb.pweb2.cqrsspringcloud.domain.events;

public interface DomainEvent {
    default String getEventType() {
        return this.getClass().getSimpleName();
    }
}
