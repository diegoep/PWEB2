package br.edu.ifpb.uploadservice.consumer;

import br.edu.ifpb.producer.commandproducer.command.EfetuaReservaEspacoCommand;
import br.edu.ifpb.uploadservice.domain.ReservaEspaco;
import br.edu.ifpb.uploadservice.service.ReservaEspacoService;
import br.edu.ifpb.uploadservice.service.erros.NenhumaUnidadeComEspacoDisponivelException;
import io.eventuate.javaclient.commonimpl.JSonMapper;
import io.eventuate.tram.commands.common.CommandReplyOutcome;
import io.eventuate.tram.commands.common.ReplyMessageHeaders;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandHandlersBuilder;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.commands.consumer.PathVariables;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.messaging.producer.MessageBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;

public class CommandConsumerHandler {

    @Autowired
    private ReservaEspacoService reservaEspacoService;

    private Logger log = LoggerFactory.getLogger(CommandConsumerHandler.class);

    private String commandChannel;

    public CommandConsumerHandler(String commandChannel) {
        this.commandChannel = commandChannel;
    }

    @Autowired
    private CommandConsumerParameters commandConsumerParameters;

    public CommandHandlers getCommandHandlers() {
        return CommandHandlersBuilder.
                fromChannel(commandChannel).
                onMessage(EfetuaReservaEspacoCommand.class, this::efetuaReservaEspaco)
                .build();
    }

    public Message efetuaReservaEspaco(CommandMessage<EfetuaReservaEspacoCommand> cm, PathVariables pv) {
        try {
            log.info("Solicitacao de reserva de espaço recebida para {} bytes",cm.getCommand().getTamanhoArquivo());
            ReservaEspaco reservaEspaco = reservaEspacoService.efetuarReservaDeEspaco(cm.getCommand().getTamanhoArquivo());
            Map<String, String> extraHeaders = new HashMap<>();
            extraHeaders.put("id", cm.getCommand().getConteudoId().toString());
            extraHeaders.put("codigoreserva", reservaEspaco.getCodigoReserva());
            MessageBuilder messageBuilder = MessageBuilder
                    .withPayload(JSonMapper.toJson(cm))
                    .withExtraHeaders("conteudo-", extraHeaders)
                    .withHeader(ReplyMessageHeaders.REPLY_OUTCOME, CommandReplyOutcome.SUCCESS.toString())
                    .withHeader(ReplyMessageHeaders.REPLY_TYPE, EfetuaReservaEspacoCommand.class.getName());
            return messageBuilder.build();
        } catch (NenhumaUnidadeComEspacoDisponivelException e) {
            return withFailure(cm);
        }
    }



}


