package com.spring.kafka.processor.example.kafkaspringprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaSpringProcessorApplication {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(KafkaSpringProcessorApplication.class);
	    app.setRegisterShutdownHook(false);
	    app.run(args);
	}

}
