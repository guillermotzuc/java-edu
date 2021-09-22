package udemy.kafka.streams.eos;

import java.time.Instant;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;


public class BankTransactionsProducer {

	public static void main(String[] args) {

		BankTransactionsProducer producerApp = new BankTransactionsProducer();

		//Create a new producer
		Producer<String, String> producer = 
				new KafkaProducer<>(producerApp.createConfiguration());
		
		//
		AtomicInteger batch = new AtomicInteger();
		while(true) {
			
			System.out.println("Producing batch" + batch.incrementAndGet());
			try {
				
				producer.send(newRandomTransaction("John"));
				Thread.sleep(100);
                producer.send(newRandomTransaction("stephane"));
                Thread.sleep(100);
                producer.send(newRandomTransaction("alice"));
                Thread.sleep(100);
				
			}catch (InterruptedException e) {

				break;
			}
		}
	}
	
	public static ProducerRecord<String, String> newRandomTransaction(String name) {
        // creates an empty json {}
        ObjectNode transaction = JsonNodeFactory.instance.objectNode();

        // { "amount" : 46 } (46 is a random number between 0 and 100 excluded)
        Integer amount = ThreadLocalRandom.current().nextInt(0, 100);

        // Instant.now() is to get the current time using Java 8
        Instant now = Instant.now();

        // we write the data to the json document
        transaction.put("name", name);
        transaction.put("amount", amount);
        transaction.put("time", now.toString());
        return new ProducerRecord<>("bank-transactions", name, transaction.toString());
    }

	private Properties createConfiguration() {

		Properties config = new Properties();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

		//Producer acks
		config.put(ProducerConfig.ACKS_CONFIG, "all");
		config.put(ProducerConfig.RETRIES_CONFIG, "2");
		config.put(ProducerConfig.LINGER_MS_CONFIG, "1");

		// leverage idempotent producer from Kafka 0.11 !
		config.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, "true");

		return config;

	}
}
