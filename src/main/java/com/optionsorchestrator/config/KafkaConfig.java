package com.optionsorchestrator.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaConfig {
    private Properties streamsConfiguration;

    public KafkaConfig() {
        streamsConfiguration = new Properties();
        streamsConfiguration.putIfAbsent(StreamsConfig.APPLICATION_ID_CONFIG, "option-event-orchestator");
        streamsConfiguration.putIfAbsent(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.0.237:9092,10.0.0.237:9093,10.0.0.237:9094");
        streamsConfiguration.putIfAbsent(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        streamsConfiguration.putIfAbsent(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, CustomSerdes.OptionEvent().getClass().getName());
        streamsConfiguration.putIfAbsent(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
        streamsConfiguration.putIfAbsent(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, 50000000);
    }

    public Properties getStreamConfiguration() {
        return streamsConfiguration;
    }
}
