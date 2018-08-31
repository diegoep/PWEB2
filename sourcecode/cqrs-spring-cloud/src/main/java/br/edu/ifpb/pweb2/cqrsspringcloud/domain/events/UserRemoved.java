package br.edu.ifpb.pweb2.cqrsspringcloud.domain.events;

import lombok.Value;

@Value
public class UserRemoved  implements DomainEvent  {

    private String login;

}
