package br.edu.ifpb.producer.service;

import br.edu.ifpb.producer.commandproducer.CommandConsumerParameters;
import br.edu.ifpb.producer.commandproducer.command.EfetuaReservaEspacoCommand;
import br.edu.ifpb.producer.domain.Conteudo;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandHandlersBuilder;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.commands.consumer.PathVariables;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

public class ReplyConsumerHandler {

    private Logger log = LoggerFactory.getLogger(ReplyConsumerHandler.class);

    @Autowired
    private ConteudoService conteudoService;

    @Autowired
    private CommandConsumerParameters parameters;

    public CommandHandlers getCommandHandlers() {
        return CommandHandlersBuilder.
                fromChannel(parameters.getReplyChannel()).
                onMessageReturningOptionalMessage(EfetuaReservaEspacoCommand.class, this::concluirReserva)
                .build();
    }

    public Optional<Message> concluirReserva(CommandMessage<EfetuaReservaEspacoCommand> cm, PathVariables pv) {
        log.info("Mensagem de resposta chegou");
        conteudoService.recuperarConteudo(cm.getCommand().getConteudoId()).ifPresent(c -> {
            c.setCodigoReserva(cm.getCommand().getCodigoReserva());
            conteudoService.atualizarConteudo(c);
        });
        return Optional.empty();
    }

}
