package br.edu.ifpb.pweb2.cqrsspringcloud.repository;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.ACL;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ACLRepository extends JpaRepository<ACL, Long> {

    public Optional<ACL> findByLogin(String userLogin);

}
