package br.edu.ifpb.producer.service;

import br.edu.ifpb.producer.commandproducer.CommandConsumerParameters;
import br.edu.ifpb.producer.commandproducer.command.EfetuaReservaEspacoCommand;
import br.edu.ifpb.producer.domain.Conteudo;
import br.edu.ifpb.producer.repository.ConteudoRepository;
import io.eventuate.javaclient.commonimpl.JSonMapper;
import io.eventuate.tram.commands.producer.CommandProducer;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import io.eventuate.tram.messaging.producer.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Collections.singleton;

@Service
public class ConteudoService {

    private final CommandProducer commandProducer;

    private final ConteudoRepository conteudoRepository;

    private final CommandConsumerParameters consumerParameters;

    @Autowired
    private MessageConsumer messageConsumer;

    public ConteudoService(CommandProducer commandProducer, ConteudoRepository conteudoRepository, CommandConsumerParameters consumerParameters) {
        this.commandProducer = commandProducer;
        this.conteudoRepository = conteudoRepository;
        this.consumerParameters = consumerParameters;
    }

    @Transactional
    public Conteudo criarConteudo(Conteudo conteudo) {

        conteudoRepository.save(conteudo);
        commandProducer.send(consumerParameters.getCommandChannel(), new EfetuaReservaEspacoCommand(conteudo.getId(), conteudo.getTamanho()), consumerParameters.getReplyChannel(), Collections.emptyMap());
        messageConsumer.subscribe(consumerParameters.getSubscriberId(), singleton(consumerParameters.getReplyChannel()), this::concluirReserva);

        return conteudo;
    }

    @Transactional
    public void concluirReserva(Message message) {
        Conteudo conteudo = recuperarConteudo(Long.parseLong(message.getHeader("conteudo-id").get())).get();
        conteudo.setCodigoReserva(message.getHeader("conteudo-codigoreserva").get());
        atualizarConteudo(conteudo);
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
