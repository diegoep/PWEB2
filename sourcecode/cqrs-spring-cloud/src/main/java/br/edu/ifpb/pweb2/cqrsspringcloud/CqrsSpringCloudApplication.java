package br.edu.ifpb.pweb2.cqrsspringcloud;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.Permission;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.Role;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.User;
import br.edu.ifpb.pweb2.cqrsspringcloud.repository.PermissionRepository;
import br.edu.ifpb.pweb2.cqrsspringcloud.repository.RoleRepository;
import br.edu.ifpb.pweb2.cqrsspringcloud.repository.UserRepository;
import br.edu.ifpb.pweb2.cqrsspringcloud.service.UserManagementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;

import static java.util.Arrays.asList;

@SpringBootApplication
@EnableAsync
@EnableBinding(Processor.class)
@Slf4j
public class CqrsSpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsSpringCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(UserManagementService userService, RoleRepository roleRepository) {
        return (args) -> {

            log.info("Seeding data");

            User user = new User();
            user.setLogin("vai432");
            user.setName("Agora vai242");
            user.setPassword("4321");
            user.setRoles(asList(roleRepository.findByName("Operador")));
            userService.saveUser(user);


        };
    }
}
