package io.heynow.eventsource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class EventsourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsourceApplication.class, args);
	}
}
