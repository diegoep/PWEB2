package br.edu.ifpb.pweb2.cqrsspringcloud.service;

import br.edu.ifpb.pweb2.cqrsspringcloud.domain.events.UserUpdated;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class ACLService {

    @TransactionalEventListener
    public void handleUserUpdated(UserUpdated event) {
        
    }

}
