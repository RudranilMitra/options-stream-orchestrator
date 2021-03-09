package com.optionsorchestrator;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class OptionsStreamOrchestratorApp {
    public static void main(String[] args) {
        SpringApplication.run(OptionsStreamOrchestratorApp.class, args);

        Properties streamsConfiguration = new Properties();
        streamsConfiguration.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "option-event-orchestator");
        streamsConfiguration.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.0.238:9092");
        streamsConfiguration.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        streamsConfiguration.putIfAbsent(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, 50000000);

        StreamsBuilder streamsBuilder = new StreamsBuilder();

    }
}
