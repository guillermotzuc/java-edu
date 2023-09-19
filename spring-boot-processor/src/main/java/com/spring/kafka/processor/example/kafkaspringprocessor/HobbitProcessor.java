package com.spring.kafka.processor.example.kafkaspringprocessor;

import org.apache.kafka.streams.processor.api.Processor;
import org.apache.kafka.streams.processor.api.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;
import org.apache.kafka.streams.state.KeyValueStore;
import org.apache.kafka.streams.state.ValueAndTimestamp;

import io.confluent.developer.avro.Hobbit;

public class HobbitProcessor implements Processor<Integer, Hobbit,Integer, Hobbit>{

	private KeyValueStore<String, ValueAndTimestamp<Object>> deviceMacAdressTableStore;
	
	@Override
	public void init(ProcessorContext<Integer, Hobbit> context) {
		// TODO Auto-generated method stub
		Processor.super.init(context);
		this.deviceMacAdressTableStore = (KeyValueStore<String, ValueAndTimestamp<Object>>) context //change object for the corect type
				.getStateStore("data-store-name");
	}

	@Override
	public void process(Record<Integer, Hobbit> record) {

		this.deviceMacAdressTableStore.get("ket-of-data-store"); 
		
		System.out.println(record.value());
		
		//send to aother topic
		//this.processorContext.forward(sparkPlugKeyMessage, bytes);
	}

}
