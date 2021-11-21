package io.confluent.developer.spirngccloud.components;

import java.time.Duration;
import java.util.stream.Stream;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import io.confluent.developer.avro.Hobbit;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Component
public class Producer {

	private final KafkaTemplate<Integer, Hobbit> template;

	Faker faker;

	@EventListener(ApplicationStartedEvent.class)
	public void generate() {

		faker = Faker.instance(); 
		final Flux<Long> interval = Flux.interval(Duration.ofMillis(5_000));
		final Flux<String> quotes = Flux.fromStream(Stream.generate(()-> faker.hobbit().quote()));

		Flux.zip(interval, quotes)
		.map(it -> 
		template.send("hobbit", 
					faker.random().nextInt(42), 
					Hobbit.newBuilder().setQuote(it.getT2()).build())
				).blockLast();

	}
}
