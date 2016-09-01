package io.heynow.eventsource.model;

import io.heynow.stream.manager.model.ProcessingModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
public
@Data
class Event {
    ExternalEvent externalEvent;
    List<ProcessingModel> processingModels;
}
