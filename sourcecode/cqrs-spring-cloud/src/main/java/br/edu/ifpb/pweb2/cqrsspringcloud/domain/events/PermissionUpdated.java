package br.edu.ifpb.pweb2.cqrsspringcloud.domain.events;

import lombok.Value;

@Value
public class PermissionUpdated implements DomainEvent {

    private String authority;

}
