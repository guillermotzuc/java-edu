package avro.producers;

import com.example.Customer;
import com.example.CustomerV2;

import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaAvroJavaProducerV2Demo {

    public static void main(String[] args) {
        Properties properties = new Properties();
        // normal producer
        properties.setProperty("bootstrap.servers", "127.0.0.1:9092");
        properties.setProperty("acks", "all");
        properties.setProperty("retries", "10");
        // avro part
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", KafkaAvroSerializer.class.getName());
        properties.setProperty("schema.registry.url", "http://127.0.0.1:8081");

        Producer<String, CustomerV2> producer = new KafkaProducer<String, CustomerV2>(properties);

        String topic = "customer-avro";

        // copied from avro examples
        CustomerV2 customer = CustomerV2.newBuilder()
                .setAge(34)
                .setFirstName("John")
                .setLastName("Doe")
                .setHeight(178f)
                .setWeight(75f)
                .setEmail("john.doe@gmail.com")
                .setPhoneNumber("(123)-456-7890")
                .build();

        ProducerRecord<String, CustomerV2> producerRecord = new ProducerRecord<String, CustomerV2>(
                topic, customer
        );

        System.out.println(customer);
        producer.send(producerRecord, new Callback() {
            @Override
            public void onCompletion(RecordMetadata metadata, Exception exception) {
                if (exception == null) {
                    System.out.println(metadata);
                } else {
                    exception.printStackTrace();
                }
            }
        });

        producer.flush();
        producer.close();

    }
}
