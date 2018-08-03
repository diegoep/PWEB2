package br.edu.ifpb.producer.commandproducer;

import br.edu.ifpb.producer.service.ReplyConsumerHandler;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;

@Configuration
public class CommandProducerConfiguration {

    @Bean
    public CommandConsumerParameters commandConsumerParameters() {
        return new CommandConsumerParameters();
    }

    @Bean
    public ReplyConsumerHandler replyConsumerHandler() {
        return new ReplyConsumerHandler();
    }

    @Bean
    public CommandDispatcher commandDispatcher(CommandConsumerParameters parameters, ReplyConsumerHandler replyConsumerHandler) {
        return new CommandDispatcher(parameters.getDispatcherId(), replyConsumerHandler.getCommandHandlers());
    }

    @Bean
    public ChannelMapping channelMapping(CommandConsumerParameters parameters) {
        return new DefaultChannelMapping(Collections.singletonMap("Reply-To", parameters.getReplyChannel()));
    }

    @Bean
    public ReplyConsumerHandler myReplyConsumer() {
        return new ReplyConsumerHandler();
    }

}
