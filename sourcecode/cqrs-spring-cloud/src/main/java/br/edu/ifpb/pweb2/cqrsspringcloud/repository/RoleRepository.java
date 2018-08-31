package br.edu.ifpb.pweb2.cqrsspringcloud.repository;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.Role;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findByName(String name);

}
