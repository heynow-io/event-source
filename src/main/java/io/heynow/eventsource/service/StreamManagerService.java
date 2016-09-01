package io.heynow.eventsource.service;

import io.heynow.stream.manager.model.ProcessingModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class StreamManagerService {

    @Value("stream.manager.url")
    String streamManagerURL;
    @Autowired
    RestTemplate restTemplate;

    public List<ProcessingModel> fetchProcessingModels(String source, String eventType) {
        return restTemplate.getForObject(streamManagerURL, List.class);
    }
}
