package br.edu.ifpb.pweb2.cqrsspringcloud.domain.events;

import lombok.Value;

@Value
public class RoleUpdated  implements DomainEvent  {

    private String name;

}
