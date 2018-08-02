package br.edu.ifpb.producer.commandproducer;

import br.edu.ifpb.producer.service.ReplyConsumer;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;
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
    public ChannelMapping channelMapping(CommandConsumerParameters parameters) {
        return new DefaultChannelMapping(Collections.singletonMap("UploadServiceAggregate", parameters.getCommandChannel()));
    }

    @Bean
    public ReplyConsumer myReplyConsumer(CommandConsumerParameters parameters, MessageConsumer messageConsumer) {
        return new ReplyConsumer(messageConsumer, parameters.getReplyChannel());
    }

}
