package udemy.kafka.streams;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.state.KeyValueStore;

public class FavoriteColor {

	public static void main(String[] args) {

		FavoriteColor favColorApp = new FavoriteColor();

		Properties config = favColorApp.createProperties();

		Topology topology = favColorApp.createTopoligy();

		KafkaStreams stream = new KafkaStreams(topology, config);
		stream.cleanUp();
		stream.start();

		Runtime.getRuntime().addShutdownHook(new Thread(stream::close));

	}

	private Properties createProperties() {

		Properties config = new Properties();
		config.put(StreamsConfig.APPLICATION_ID_CONFIG, "favorite-color-app");
		config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());

		return config;
	}

	private Topology createTopoligy() {

		StreamsBuilder builder = new StreamsBuilder();

		KStream<String, String> streamInput = builder.stream("favorite-color-input");

		KStream<String, String> favoriteColor = streamInput
				.selectKey((key, value) -> {
					
					return key.toLowerCase();
				})
				.mapValues(value -> value.toLowerCase())
				.filter((user, colour) -> Arrays.asList("green", "blue", "red").contains(colour));


		favoriteColor.to("user-keys-and-colours");

		Serde<String> stringSerde = Serdes.String();
		Serde<Long> longSerde = Serdes.Long();

		// step 2 - we read that topic as a KTable so that updates are read correctly
		KTable<String, String> usersAndColoursTable = builder.table("user-keys-and-colours");

		// step 3 - we count the occurences of colours
		KTable<String, Long> favouriteColours = usersAndColoursTable
				// 5 - we group by colour within the KTable
				.groupBy((user, colour) -> new KeyValue<>(colour, colour))
				.count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as("CountsByColours")
						.withKeySerde(stringSerde)
						.withValueSerde(longSerde));

		// 6 - we output the results to a Kafka Topic - don't forget the serializers
		favouriteColours.toStream().to("favorite-color-output", Produced.with(Serdes.String(),Serdes.Long()));

		return builder.build();
	}
}
