package udemy.kafka.streams;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;

public class MoviesKtable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public Properties createProperties() {
		
		Properties conf = new Properties();
		conf.put(StreamsConfig.APPLICATION_ID_CONFIG, "movies-app");
		conf.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		conf.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		conf.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		conf.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

//		MovieTicketSales ff = new MovieTicketSales();
		 
		return conf;
	}
	
//	  public static SpecificAvroSerde<MovieTicketSales> ticketSaleSerde(final Properties envProps) {
//		    final SpecificAvroSerde<MovieTicketSales> serde = new SpecificAvroSerde<>();
//		    serde.configure(Collections.singletonMap(
//		            AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG,
//		            envProps.getProperty("schema.registry.url")), false);
//		    return serde;
//		  }

}
