package io.confluent.developer.spirngccloud.components;

import java.util.Arrays;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class Processor {

	@Autowired
    public void process(StreamsBuilder builder) {

        final Serde<Integer> integerSerde = Serdes.Integer();
        final Serde<String> stringSerde = Serdes.String();
        final Serde<Long> longSerde = Serdes.Long();

        KStream<Integer, String> textLines = builder.stream("hobbit", Consumed.with(integerSerde, stringSerde));
        KTable<String, Long> wordCounts = textLines
    		.flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
    		.groupBy((key, value) -> value, Grouped.with(stringSerde, stringSerde))
    		.count(Materialized.as("counts"));
        
        wordCounts.toStream().to("streams-wordcount-output", Produced.with(stringSerde, longSerde));
    }
}
