package br.edu.ifpb.producer.service;

import br.edu.ifpb.producer.commandproducer.CommandConsumerParameters;
import br.edu.ifpb.producer.commandproducer.command.EfetuaReservaEspacoCommand;
import br.edu.ifpb.producer.domain.Conteudo;
import br.edu.ifpb.producer.events.ConteudoInicializado;
import br.edu.ifpb.producer.repository.ConteudoRepository;
import io.eventuate.tram.commands.producer.CommandProducer;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ConteudoService {

    private final CommandProducer commandProducer;

    private final ConteudoRepository conteudoRepository;

    private final CommandConsumerParameters consumerParameters;

    private final DomainEventPublisher domainEventPublisher;

    public ConteudoService(CommandProducer commandProducer, ConteudoRepository conteudoRepository, CommandConsumerParameters consumerParameters, DomainEventPublisher domainEventPublisher) {
        this.commandProducer = commandProducer;
        this.conteudoRepository = conteudoRepository;
        this.consumerParameters = consumerParameters;
        this.domainEventPublisher = domainEventPublisher;
    }

    @Transactional
    public Conteudo criarConteudo(Conteudo conteudo) {

        conteudoRepository.save(conteudo);
        ConteudoInicializado conteudoInicializado = new ConteudoInicializado(conteudo.getTamanho());
        domainEventPublisher.publish(consumerParameters.getAggregateType(), consumerParameters.getAggregateType()+conteudo.getId(), Collections.singletonList(conteudoInicializado));

        return conteudo;
    }

    @Transactional
    public Conteudo atualizarConteudo(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }

    public Optional<Conteudo> recuperarConteudo(Long id) {
        return conteudoRepository.findById(id);
    }

    public List<Conteudo> listarConteudos() {
        return conteudoRepository.findAll();
    }
}
