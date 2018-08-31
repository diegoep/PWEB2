package br.edu.ifpb.pweb2.cqrsspringcloud.service;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.Permission;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.Role;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.User;
import br.edu.ifpb.pweb2.cqrsspringcloud.repository.PermissionRepository;
import br.edu.ifpb.pweb2.cqrsspringcloud.repository.RoleRepository;
import br.edu.ifpb.pweb2.cqrsspringcloud.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManagementService {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PermissionRepository permissionRepository;

    public UserManagementService(UserRepository userRepository, RoleRepository roleRepository, PermissionRepository permissionRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user.updated());
    }

    public void deleteUser(User user) {userRepository.delete(user.removed());}

    public void saveRole(Role role) { roleRepository.save(role.updated());}

    public void savePermission(Permission permission) { permissionRepository.save(permission.updated());}

}
