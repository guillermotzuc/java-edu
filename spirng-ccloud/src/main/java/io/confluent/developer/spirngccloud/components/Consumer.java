package io.confluent.developer.spirngccloud.components;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import io.confluent.developer.avro.Hobbit;

@Component
public class Consumer {

//	@KafkaListener(topics = { "hobbit" }, groupId = "spring-boot-kafka")
//	public void consume(String quote) {
//		
//		System.out.println(quote);
//	}
	
	@KafkaListener(topics = { "hobbit" }, groupId = "spring-boot-kafka")
	public void consume(ConsumerRecord<Integer, Hobbit> record) {
		
		System.out.println(record.key());
		System.out.println(record.value());
	}
}
