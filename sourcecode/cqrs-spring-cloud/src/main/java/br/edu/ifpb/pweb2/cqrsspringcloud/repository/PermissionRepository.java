package br.edu.ifpb.pweb2.cqrsspringcloud.repository;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.Permission;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {

    public Permission findByAuthority(String authority);

}
