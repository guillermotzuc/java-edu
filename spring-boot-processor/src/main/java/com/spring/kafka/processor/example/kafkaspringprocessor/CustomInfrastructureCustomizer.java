package com.spring.kafka.processor.example.kafkaspringprocessor;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.Topology;
import org.springframework.kafka.config.KafkaStreamsInfrastructureCustomizer;
import org.springframework.stereotype.Component;


import io.confluent.developer.avro.Hobbit;
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

	
	private Serde<Hobbit> hobbitSerde() {

		//# See: https://docs.confluent.io/platform/current/streams/developer-guide/datatypes.html
		// When you want to override serdes explicitly/selectively
		final Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url",
				"http://127.0.0.1:8081");

		final Serde<Hobbit> valueSpecificAvroSerde = new SpecificAvroSerde<>();
		valueSpecificAvroSerde.configure(serdeConfig, false);
		
		return valueSpecificAvroSerde;
	}
//	
//	/**
//	 * Get a GenericRecord serde.
//	 * @return
//	 */
//	public Serde<GenericRecord> getGenericSerde() {
//
//		final Serde<GenericRecord> genericSerde = new GenericAvroSerde();
//		Map<String, String> config = new HashMap<>();
//
//		config.put(KafkaCommonClientConfigs.BASIC_AUTH_CRED_SRC_CONFIG, confluentConfigs.getAuthCredencialResource());
//		config.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, confluentConfigs.getSchemaRegistryUrl());
//		config.put(KafkaCommonClientConfigs.SECURITY_PROTOCOL_CONFIG, confluentConfigs.getSecurityProtocol());
//		config.put(KafkaCommonClientConfigs.SCHEMA_REGISTRY_AUTH_USER_INFO_CONFIG, confluentConfigs.getSchemaRegistryBasicAuthInfo());
//		
//		genericSerde.configure(config, false);
//		return genericSerde;
//	}
//
	@Override
	public void configureBuilder(StreamsBuilder builder) {

//		builder.globalTable(topic,
//				Materialized.<String, Tag, KeyValueStore<Bytes, byte[]>>as(<name>)
//				.withKeySerde(Serdes.String())
//				.withValueSerde(this.tagJsonSerde()));
//		
//		builder.globalTable(CommonConstants.TopicNames.SITE_TOPIC_WITH_KEY,
//				Materialized.<String, GenericRecord, KeyValueStore<Bytes, byte[]>>as(<name>)
//					.withKeySerde(Serdes.String())
//					.withValueSerde(this.getGenericSerde()));
	}

	@Override
	public void configureTopology(Topology topology) {
		
//		topology
//			.addSource("source", new IntegerDeserializer(), this.hobbitSerde().deserializer(), "hobbit")
//			.addProcessor("hobbitProcessor", HobbitProcessor::new, "source")
//			.addSink("IgnitionToEdgeData", KafkaConfig.OUTPUT_TOPIC, new StringSerializer(), VALUE_JSON_SE, "hobbitProcessor")
//			;

		
//		topology
//		.addSource("<name>", new StringDeserializer(),  new ByteArrayDeserializer(), <name>)
//		.addSource("<name>", new StringDeserializer(),  <name>, KafkaConfig.<name>)
//		.addSource("<name>", new StringDeserializer(),  COMMAND_JSON_DE, KafkaConfig.<name>)
//		.addSource("<name>", new StringDeserializer(), SITE_CONNECTION_VALUE_JSON_DE, KafkaConfig.<name>)
//		.addProcessor("<name>", <name>::new, "<name>")
//		.addProcessor("<name>", <name>::new, "<name>")
//		.addProcessor("<name>", <name>::new, "<name>")
//		.addProcessor("<name>", () -> new <name>(<name>), "<name>")
//		.addStateStore(this.<name>(), "<name>", "XcapeProcessor", "<name>")
//		.addSink("<name>", KafkaConfig.OUTPUT_TOPIC, new StringSerializer(), VALUE_JSON_SE, "<name>")
//		.addSink("<name>", KafkaConfig.OUTPUT_TOPIC, new StringSerializer(), VALUE_JSON_SE, "<name>")
//		.addSink("<name>", KafkaConfig.OUTPUT_IGNITION_TOPIC, new StringSerializer(), new ByteArraySerializer(), "<name>")
//		.addSink("<name>", KafkaConfig.OUTPUT_TOPIC, new StringSerializer(), VALUE_JSON_SE, "<name>");

	}

}
