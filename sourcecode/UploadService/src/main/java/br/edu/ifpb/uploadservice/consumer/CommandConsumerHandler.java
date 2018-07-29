package br.edu.ifpb.uploadservice.consumer;

import br.edu.ifpb.uploadservice.consumer.command.EfetuaReservaEspacoCommand;
import br.edu.ifpb.uploadservice.service.ReservaEspacoService;
import br.edu.ifpb.uploadservice.service.erros.NenhumaUnidadeComEspacoDisponivelException;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandHandlersBuilder;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.commands.consumer.PathVariables;
import io.eventuate.tram.messaging.common.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;

public class CommandConsumerHandler {

    @Autowired
    private ReservaEspacoService reservaEspacoService;

    private Logger log = LoggerFactory.getLogger(CommandConsumerHandler.class);

    private String commandChannel;

    public CommandConsumerHandler(String commandChannel) {
        this.commandChannel = commandChannel;
    }

    public CommandHandlers getCommandHandlers() {
        return CommandHandlersBuilder.
                fromChannel(commandChannel).
                onMessage(EfetuaReservaEspacoCommand.class, this::efetuaReservaEspaco)
                .build();
    }

    public Message efetuaReservaEspaco(CommandMessage<EfetuaReservaEspacoCommand> cm, PathVariables pv) {
        try {
            log.info("Solicitacao de reserva de espaço recebida para {} bytes",cm.getCommand().getTamanhoArquivo());
            reservaEspacoService.efetuarReservaDeEspaco(cm.getCommand().getTamanhoArquivo());
        } catch (NenhumaUnidadeComEspacoDisponivelException e) {
            return withFailure();
        }
        return withSuccess();
    }



}


