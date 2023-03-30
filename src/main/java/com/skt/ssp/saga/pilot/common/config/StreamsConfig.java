package com.skt.ssp.saga.pilot.common.config;

import org.apache.kafka.common.serialization.Serdes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafkaStreams
public class StreamsConfig {
    @Bean(name= KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kafkaStreamsConfiguration () {
        Map<String, Object> configs = new HashMap<>();
        configs.put(org.apache.kafka.streams.StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configs.put(org.apache.kafka.streams.StreamsConfig.APPLICATION_ID_CONFIG, "ssp-streams-id");
        configs.put(org.apache.kafka.streams.StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        configs.put(org.apache.kafka.streams.StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
        //configs.put(StreamsConfig.NUM_STREAM_THREADS_CONFIG, "2");
        configs.put(org.apache.kafka.streams.StreamsConfig.PROCESSING_GUARANTEE_CONFIG, org.apache.kafka.streams.StreamsConfig.EXACTLY_ONCE_V2);


        return new KafkaStreamsConfiguration(configs);
    }
}
