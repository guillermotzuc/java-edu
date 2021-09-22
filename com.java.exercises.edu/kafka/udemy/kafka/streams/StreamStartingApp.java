package udemy.kafka.streams;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;

public class StreamStartingApp {

	public static void main(String[] args) {
		
		Properties properties = new Properties();
		properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "word-counts");
		properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		properties.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		properties.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

		StreamStartingApp streamApp = new StreamStartingApp();
		
		KafkaStreams stream = new KafkaStreams(streamApp.createTopology(), properties);
		stream.start();
		
		//Add shutdown
		Runtime.getRuntime().addShutdownHook(new Thread(stream::close));
		
		
	}
	
	public Topology createTopology() {
		
		StreamsBuilder builder = new StreamsBuilder();
		
		 // 1 - stream from Kafka
		KStream<String,String> wordCount = builder.stream("word-count-input");
		
		 // 2 - map values to lowercase
		KTable<String,Long> ktable = wordCount.mapValues(value -> value.toLowerCase())
						        // can be alternatively written as:
						        // .mapValues(String::toLowerCase)
						        // 3 - flatmap values split by space
								.flatMapValues(textLine -> Arrays.asList(textLine.split("\\W+")))
						        // 4 - select key to apply a key (we discard the old key)
								.selectKey((k,v) -> v)
						        // 5 - group by key before aggregation
								.groupByKey()
								// 6 - count occurences
								.count(Materialized.as("Counts"));
		
       // 7 - to in order to write the results back to kafka
		ktable.toStream().to("word-count-output", Produced.with(Serdes.String(), Serdes.Long()));
		
		return builder.build();
	}

}
