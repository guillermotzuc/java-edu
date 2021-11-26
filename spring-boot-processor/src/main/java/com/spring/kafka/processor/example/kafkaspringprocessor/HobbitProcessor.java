package com.spring.kafka.processor.example.kafkaspringprocessor;

import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.Record;

import io.confluent.developer.avro.Hobbit;

public class HobbitProcessor implements Processor<Integer, Hobbit,Integer, Hobbit>{

	@Override
	public void process(Record<Integer, Hobbit> record) {

		System.out.println(record.value());
	}

}
