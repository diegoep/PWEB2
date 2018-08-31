package br.edu.ifpb.pweb2.cqrsspringcloud.service;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.ACL;
import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.UserUpdated;
import br.edu.ifpb.pweb2.cqrsspringcloud.repository.ACLRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class RemoteEventConsumer {

    private final ACLRepository aclRepository;

    public RemoteEventConsumer(ACLRepository aclRepository) {
        this.aclRepository = aclRepository;
    }

    @StreamListener(value = Sink.INPUT, condition = "payload.eventType == 'UserUpdated'")
    public void handleRemoteEvent(UserUpdated userUpdated) {
        log.info("CHEGOU EVENTO REMOTO!!!!!!!!!!!!");
        Optional<ACL> aclOptional = aclRepository.findByLogin(userUpdated.getLogin());
        if (!aclOptional.isPresent()) {
            ACL acl = new ACL();
            acl.setLogin(userUpdated.getLogin());
            acl.setPermissionName(userUpdated.getPermissionName());
            acl.setRoleName(userUpdated.getRoleName());
            aclRepository.save(acl);
            log.info("id do acl {}",acl.getId());
        }

        //@TODO lógica para atualizar a view
    }

}
