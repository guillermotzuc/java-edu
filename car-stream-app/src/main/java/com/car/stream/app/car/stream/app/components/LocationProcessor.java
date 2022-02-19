package com.car.stream.app.car.stream.app.components;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.car.stream.app.car.stream.app.KafkaConfig;

import io.confluent.developer.avro.Location;
import io.confluent.developer.avro.Score;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

@Component
public class LocationProcessor {

	@Autowired
	public void process(StreamsBuilder builder) {

		final Serde<String> keySerde = Serdes.String();

		//# See: https://docs.confluent.io/platform/current/streams/developer-guide/datatypes.html
		// When you want to override serdes explicitly/selectively
		final Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url",
				"http://127.0.0.1:8081");

		final Serde<Score> valueSpecificAvroSerde = new SpecificAvroSerde<>();
		valueSpecificAvroSerde.configure(serdeConfig, false); // `false` for record values

		final Serde<Location> locationSpecificAvroSerde = new SpecificAvroSerde<>();
		locationSpecificAvroSerde.configure(serdeConfig, false); // `false` for record values
		
		/* Define stream */
		KStream<String, Score> scoreStream = builder
				.stream(KafkaConfig.USER_SCORE_TOPIC_NAME, Consumed.with(keySerde, valueSpecificAvroSerde));
		
		
		@SuppressWarnings("static-access")
		KTable<String, Location> locations = scoreStream
				.mapValues(score -> Location.newBuilder().setLocation(score.getLocation()).build())
				.groupBy(
						
						(key, value) -> value.getLocation().subSequence(0, 3)
												.toString()
												.toUpperCase(), 
						
						Grouped.with(Serdes.String(), locationSpecificAvroSerde)
						
						)
				.aggregate(
						
						() -> Location.newBuilder()
									.setLocation("")
									.build()
						, (k, v, location) -> v,
							Materialized.as(KafkaConfig.LOCATIONS_TOPIC_NAME)
							.with(Serdes.String(), locationSpecificAvroSerde));

		locations.toStream().to(KafkaConfig.LOCATIONS_TOPIC_NAME);
	}
}
