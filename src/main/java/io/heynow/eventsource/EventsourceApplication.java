package io.heynow.eventsource;

import io.heynow.stream.manager.client.EnableStreamManagerClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableStreamManagerClient
@EnableEurekaClient
public class EventsourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsourceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
