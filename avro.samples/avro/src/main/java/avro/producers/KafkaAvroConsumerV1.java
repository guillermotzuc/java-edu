package avro.producers;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import com.example.Customer;

import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;

public class KafkaAvroConsumerV1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Properties properties = new Properties();
		properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
		properties.put(ConsumerConfig.GROUP_ID_CONFIG, "my-avro-consumer");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		properties.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
		
		properties.put("specific.avro.reader", "true");
		
		KafkaConsumer<String, Customer> consumer = 
				new KafkaConsumer<>(properties);
		
		String topic = "customer-avro";
		
		consumer.subscribe(Collections.singleton(topic));
		
		System.out.println("Waiting for data");
		
		while(true) {
			
			ConsumerRecords<String, Customer> records = consumer.poll(500);
			for(ConsumerRecord<String, Customer> record : records) {
				
				Customer customer = record.value();
				System.out.println(customer);
				
				if(customer.getAge() > 50) {
					
					System.out.println("you are old");
				}
			}
		}
	}

}
