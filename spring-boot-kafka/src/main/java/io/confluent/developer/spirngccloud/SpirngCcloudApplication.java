package io.confluent.developer.spirngccloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpirngCcloudApplication {

	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(SpirngCcloudApplication.class);
	    app.setRegisterShutdownHook(false);
	    app.run(args);
	}

}
