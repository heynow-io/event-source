package io.heynow.eventsource.service;

import io.heynow.eventsource.model.Event;
import io.heynow.eventsource.model.ExternalEvent;
import io.heynow.stream.manager.model.ProcessingModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.router.AbstractMappingMessageRouter;
import org.springframework.integration.router.PayloadTypeRouter;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class EventService {

    private final Source source;

    @Autowired
    StreamManagerService streamManagerService;
    @Autowired
    AbstractMappingMessageRouter messageRouter;

    public void processEvent(ExternalEvent externalEvent) {
        List<ProcessingModel> processingModels = streamManagerService.fetchProcessingModels(externalEvent.getApplication(), externalEvent.getEventType());

        ProcessingModel currentProcessingModel = processingModels.remove(0);
        messageRouter.setChannelMapping("streamInteger", currentProcessingModel.getStreamId());

        Event event = Event.builder().externalEvent(externalEvent).processingModels(processingModels).build();
        source.output().send(MessageBuilder.withPayload(event).build());
    }

    @Bean
    AbstractMappingMessageRouter getMessageRouter(){
        return new PayloadTypeRouter();
    }
}
