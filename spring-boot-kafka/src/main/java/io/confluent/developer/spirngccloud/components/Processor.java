package io.confluent.developer.spirngccloud.components;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

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

import io.confluent.developer.avro.Hobbit;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

@Component
public class Processor {

	@Autowired
	public void process(StreamsBuilder builder) {

		final Serde<Integer> integerSerde = Serdes.Integer();
		final Serde<String> stringSerde = Serdes.String();
		final Serde<Long> longSerde = Serdes.Long();

		//# See: https://docs.confluent.io/platform/current/streams/developer-guide/datatypes.html
		// When you want to override serdes explicitly/selectively
		final Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url",
				"http://127.0.0.1:8081");

		final Serde<Hobbit> valueSpecificAvroSerde = new SpecificAvroSerde<>();
		valueSpecificAvroSerde.configure(serdeConfig, false); // `false` for record values

		KStream<Integer, Hobbit> textLines = builder.stream("hobbit", Consumed.with(integerSerde, valueSpecificAvroSerde));
		KTable<String, Long> wordCounts = textLines
				.flatMapValues(value -> Arrays.asList(String.valueOf(value.getQuote()).toLowerCase().split("\\W+")))
				.groupBy((key, value) -> value, Grouped.with(stringSerde, stringSerde))
				.count(Materialized.as("counts"));

		wordCounts.toStream().to("streams-wordcount-output", Produced.with(stringSerde, longSerde));
	}
}
