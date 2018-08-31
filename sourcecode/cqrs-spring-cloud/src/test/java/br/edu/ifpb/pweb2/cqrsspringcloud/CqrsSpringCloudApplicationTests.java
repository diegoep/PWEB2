package br.edu.ifpb.pweb2.cqrsspringcloud;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.User;
import br.edu.ifpb.pweb2.cqrsspringcloud.repository.RoleRepository;
import br.edu.ifpb.pweb2.cqrsspringcloud.service.UserManagementService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.test.context.junit4.SpringRunner;

import static java.util.Arrays.asList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CqrsSpringCloudApplicationTests {

    @Autowired
    private UserManagementService userManagementService;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void deveCriarUsuario() {
        User user = new User();
        user.setName("Joao da Silva222");
        user.setPassword("123");
        user.setLogin("joao66663");
        user.setRoles(asList(roleRepository.findByName("Administrador")));
        userManagementService.saveUser(user);
    }

    @SpringBootApplication
    @EnableBinding(Processor.class)
    public static class DefaultClass {

    }

}
