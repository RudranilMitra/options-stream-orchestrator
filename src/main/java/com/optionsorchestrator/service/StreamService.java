package com.optionsorchestrator.service;

import com.optionsorchestrator.config.KafkaStreamConfig;
import com.optionsorchestrator.model.OptionEvent;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class StreamService {
    @Autowired
    private KafkaStreamConfig kafkaConfig;

    @Value("${kafka.inbound-topic}")
    private String inboundTopicName;

    @Value("${kafka.redis-topic")
    private String outboundRedisTopicName;

    @Bean
    public void streamEvents() {
        Properties streamsConfiguration = kafkaConfig.getStreamConfiguration();

        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, OptionEvent> stream = streamsBuilder.stream(inboundTopicName);

        stream.foreach(
                (k, v) -> System.out.println("Key: " + k + " Call Size: " + v.getCallStrikePrices().size() + " Put Size: " + v.getPutStrikePrices().size()));

        Topology topology = streamsBuilder.build();
        KafkaStreams streams = new KafkaStreams(topology, streamsConfiguration);

        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(
                () -> {
                    streams.close();
                }
        ));

    }
}