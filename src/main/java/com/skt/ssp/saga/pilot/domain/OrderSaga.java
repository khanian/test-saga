package com.skt.ssp.saga.pilot.domain;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@EnableKafkaStreams
public class OrderSaga {
    @Bean
    public KStream<String, String> kStream(StreamsBuilder streamsBuilder) {
        KStream<String, String> stream = streamsBuilder.stream("ssp-topic");
        /*stream.groupBy((key, value) -> value)
                .count()
                .toStream()
                .peek((key, value) -> System.out.println("key="+ key + "value=" + value));
*/
        stream.peek((key, value) -> System.out.println("Stream:::: message=" + value))
                .map((key, value) -> KeyValue.pair(key, "from-to : "+value))
                .to("ssp-topic-to");

        //return streamsBuilder.stream("ssp-topic");

        return stream;
    }
}

