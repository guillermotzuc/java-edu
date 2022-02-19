package com.car.stream.app.car.stream.app;

import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.KafkaStreamsInfrastructureCustomizer;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.kafka.config.TopicBuilder;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

@EnableKafka
@Configuration
public class KafkaConfig {

	private final String SCHEMA_REGISTRY_URL = "http://127.0.0.1:8081";
	public final static String USER_SCORE_TOPIC_NAME= "user_score";
	public final static String LOCATIONS_TOPIC_NAME= "locations_table";
	public final static String LOCATIONS_LATAM_TOPIC_NAME= "latam_locations";

	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	@Primary
	public KafkaStreamsConfiguration kStreamsConfig() {

		return new KafkaStreamsConfiguration(this.getConfigs());
	}
	
	
	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_BUILDER_BEAN_NAME)
	@Primary
	public StreamsBuilderFactoryBean streamsBuilderFactoryBean(KafkaStreamsConfiguration configuration, 
			KafkaStreamsInfrastructureCustomizer customizer)
			throws Exception {

		StreamsBuilderFactoryBean streamsBuilderFactoryBean =
				new StreamsBuilderFactoryBean(configuration);
		streamsBuilderFactoryBean.afterPropertiesSet();
		streamsBuilderFactoryBean.setInfrastructureCustomizer(customizer);
		streamsBuilderFactoryBean.setCloseTimeout(10);
		return streamsBuilderFactoryBean;
	}

	private Map<String, Object> getConfigs() {

		return Map.of(
				StreamsConfig.APPLICATION_ID_CONFIG, "testStreams",
				StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
				StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName(),
				AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL,
				StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class
					);
	}
	
	@Bean
	public NewTopic topic1() {
		
		return TopicBuilder.name(LOCATIONS_TOPIC_NAME)
				.partitions(2)
				.replicas(1)
				.compact()
				.build();
	}
	
	@Bean
	public NewTopic topic2() {
		
		return TopicBuilder.name(LOCATIONS_LATAM_TOPIC_NAME)
				.partitions(2)
				.replicas(1)
				.compact()
				.build();
	}
}
