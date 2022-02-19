package io.confluent.developer.spirngccloud;

import java.util.Map;

import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import io.confluent.developer.avro.Hobbit;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;

@EnableKafka //ADD KAFKA STREAMS 
@EnableKafkaStreams  //ADD KAFKA STREAMS 
@Configuration
public class KafkaConfiguration {
	
	private final String SCHEMA_REGISTRY_URL = "http://127.0.0.1:8081";

	@Bean
	public ProducerFactory<Integer, Hobbit> producerFactory(){

		return new DefaultKafkaProducerFactory<>(
				Map.of(
						CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
						ProducerConfig.RETRIES_CONFIG,0,
						ProducerConfig.BUFFER_MEMORY_CONFIG,33554432,
						ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class,
						ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class,
						AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL
						));
	}
	
	@Bean
	public ConsumerFactory<Integer, Hobbit> consumerFactory(){

		return new DefaultKafkaConsumerFactory<>(
				Map.of(
						CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
						ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class,
						ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class,
						AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL
						));
	}
	
	@Bean
	public KafkaTemplate<Integer, Hobbit> kafkaTemplate(){
		
		return new KafkaTemplate<>(producerFactory());
	}
	
	@Bean
	public KafkaAdmin admin() {
		
		return new KafkaAdmin(Map.of(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"));
	}
	
	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	public KafkaStreamsConfiguration kStreamsConfig() {
		
		return new KafkaStreamsConfiguration(
				Map.of(
					StreamsConfig.APPLICATION_ID_CONFIG, "testStreams",
					StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092",
					StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass().getName(),
					AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, SCHEMA_REGISTRY_URL,
					StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class
						));
				
	}
	
	@Bean
	public NewTopic topic1() {
		
		return TopicBuilder.name("hobbit")
				.partitions(2)
				.replicas(1)
				.compact()
				.build();
	}
	
	@Bean
	 NewTopic counts() {
	        return TopicBuilder.name("streams-wordcount-output").partitions(6).replicas(3).build();
	 }
}
