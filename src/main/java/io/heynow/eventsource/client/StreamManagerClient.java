package io.heynow.eventsource.client;

import io.heynow.stream.manager.client.model.ProcessingModel;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(
        name = "stream-manager",
        url = "${stream-manager.url:}"
)
public interface StreamManagerClient {
    @RequestMapping(method = RequestMethod.GET, value = "/processing-models/{eventType}/{eventSource}")
    List<ProcessingModel> getProcessingModel(@PathVariable("eventType") String eventType, @PathVariable("eventSource") String eventSource);
}