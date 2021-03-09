package com.optionsorchestrator.service;

import com.optionsorchestrator.config.KafkaConfig;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Component
public class StreamService {
    @Autowired
    private KafkaConfig kafkaConfig;

    @Bean
    public void streamEvents() {
        Properties streamsConfiguration = kafkaConfig.getStreamConfiguration();

        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, String> stream = streamsBuilder.stream("option_events_inbound");
        stream.foreach(
                (k, v) -> System.out.println("Key: " + k + " Value: " + v)
        );

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