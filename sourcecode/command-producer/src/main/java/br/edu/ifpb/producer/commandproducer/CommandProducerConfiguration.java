package br.edu.ifpb.producer.commandproducer;

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
    public ChannelMapping channelMapping(CommandConsumerParameters parameters) {
        return new DefaultChannelMapping(Collections.singletonMap("Reply-To", "Reply-to"));
    }

}
