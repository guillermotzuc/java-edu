package avro.producers;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import com.example.Customer;

import avro.shaded.com.google.common.base.Optional;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class KafkaAvroProducerV1 {


	public static void main(String[] args) {
		
		Properties config = new Properties();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.ACKS_CONFIG, "1");
		config.put(ProducerConfig.RETRIES_CONFIG, "10");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		config.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://127.0.0.1:8081");
		
		KafkaProducer<String, Customer> producer = 
				new KafkaProducer<>(config);
		
		String topic = "customer-avro";
		Customer consumer = Customer.newBuilder()
				.setFirstName("Guillermo")
				.setHeight(1.60f)
				.setLastName("tzuc")
				.setWeight(70.0f)
				.setAge(31)
				.build();
		
		ProducerRecord<String, Customer> record = 
				new ProducerRecord<String, Customer>(topic, consumer);
		
		producer.send(record, new Callback() {
			
			@Override
			public void onCompletion(RecordMetadata metadata, Exception exception) {

				if(exception == null) {
					
					System.out.println("Success!");
					System.out.println(metadata.toString());
				} else {
					
					exception.printStackTrace();
				}
			}
		});
		
		producer.flush();
		producer.close();
	}
}
