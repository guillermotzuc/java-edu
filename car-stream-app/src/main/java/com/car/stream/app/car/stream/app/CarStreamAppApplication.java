package com.car.stream.app.car.stream.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarStreamAppApplication {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(CarStreamAppApplication.class);
	    app.setRegisterShutdownHook(false);
	    app.run(args);
	}

}
