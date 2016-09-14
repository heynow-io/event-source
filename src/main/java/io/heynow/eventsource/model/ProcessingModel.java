package io.heynow.eventsource.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Builder
@Data
public class ProcessingModel {

    private String eventSource;
    private String eventType;
    private String streamId;
    private List<Consumer> consumers;

    public ProcessingModel getNextProcessingModel() {
        if (consumers.size() == 0) {
            throw new IllegalStateException("There are no consumers left");
        }
        List<Consumer> tail = new ArrayList<>(consumers.subList(1, consumers.size()));

        ProcessingModel model = ProcessingModel.builder().build();
        model.setConsumers(tail);
        model.setEventSource(eventSource);
        model.setStreamId(streamId);
        return model;
    }

    public Consumer getCurrent() {
        return consumers.stream().findFirst().get();
    }

}
