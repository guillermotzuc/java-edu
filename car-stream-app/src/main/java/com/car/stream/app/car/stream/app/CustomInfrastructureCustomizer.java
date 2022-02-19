package com.car.stream.app.car.stream.app;


import java.util.Collections;
import java.util.Map;

import org.apache.kafka.common.serialization.Serde;
import org.springframework.kafka.config.KafkaStreamsInfrastructureCustomizer;
import org.springframework.stereotype.Component;

import io.confluent.developer.avro.Score;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

/**
 * {@link KafkaStreamsInfrastructureCustomizer}
 * @author gtzuc@anexinet.com
 *
 */
@Component
public class CustomInfrastructureCustomizer implements KafkaStreamsInfrastructureCustomizer {
	
	CustomInfrastructureCustomizer() {
		
	}
	
	private Serde<Score> ScoreSerde() {

		//# See: https://docs.confluent.io/platform/current/streams/developer-guide/datatypes.html
		// When you want to override serdes explicitly/selectively
		final Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url",
				"http://127.0.0.1:8081");

		final Serde<Score> valueSpecificAvroSerde = new SpecificAvroSerde<>();
		valueSpecificAvroSerde.configure(serdeConfig, false);
		
		return valueSpecificAvroSerde;
	}

}
