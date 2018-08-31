package br.edu.ifpb.pweb2.cqrsspringcloud.repository;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
