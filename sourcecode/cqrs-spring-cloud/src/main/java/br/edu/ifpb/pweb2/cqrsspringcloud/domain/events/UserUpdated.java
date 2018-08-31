package br.edu.ifpb.pweb2.cqrsspringcloud.domain.events;

import lombok.Value;

@Value
public class UserUpdated  implements DomainEvent {

    private String login;
    private String roleName;
    private String permissionName;

}
