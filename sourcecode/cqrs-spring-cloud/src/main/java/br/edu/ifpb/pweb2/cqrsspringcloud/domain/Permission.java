package br.edu.ifpb.pweb2.cqrsspringcloud.domain;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.PermissionUpdated;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.RoleUpdated;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Permission extends AbstractAggregateRoot {

    @Id
    @GeneratedValue
    private Long id;

    private String authority;

    public Permission() {}

    public Permission(String authority) {
        this.authority = authority;
    }

    public Permission updated(){
        registerEvent(new PermissionUpdated(this.authority));
        return this;
    }

}
