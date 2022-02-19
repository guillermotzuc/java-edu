package io.confluent.developer.spirngccloud.controllers;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RestService {
	
	private final StreamsBuilderFactoryBean factoryBeam;
	
	@GetMapping("/count/{word}")
	public Long getCount(@PathVariable String word) {
		
		final KafkaStreams  kafkaStreams = factoryBeam.getKafkaStreams();
		final ReadOnlyKeyValueStore<String, Long> counts = 
				kafkaStreams.store(StoreQueryParameters.fromNameAndType("counts", QueryableStoreTypes.keyValueStore()));
		
		return counts.get(word);
	}
}
