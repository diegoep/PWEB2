package br.edu.ifpb.pweb2.cqrsspringcloud.domain;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.RoleUpdated;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.UserUpdated;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Role extends AbstractAggregateRoot  {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Permission> permissions;

    public Role() {}

    public Role(String name, List<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
    }


    public Role updated(){
        registerEvent(new RoleUpdated(this.name));
        return this;
    }

}
