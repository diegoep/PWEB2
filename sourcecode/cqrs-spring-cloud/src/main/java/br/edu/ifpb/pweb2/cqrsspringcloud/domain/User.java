package br.edu.ifpb.pweb2.cqrsspringcloud.domain;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.UserRemoved;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.UserUpdated;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.AbstractAggregateRoot;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(exclude = "domainEvents")
public class User extends AbstractAggregateRoot {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String login;

    private String password;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Role> roles;

    public User updated(){
        registerEvent(new UserUpdated(this.login, this.getRoles().stream().findFirst().get().getName(), this.getRoles().stream().findFirst().get().getPermissions().stream().findFirst().get().getAuthority()));
        return this;
    }

    public User removed() {
        registerEvent(new UserRemoved(this.login));
        return this;
    }

}
