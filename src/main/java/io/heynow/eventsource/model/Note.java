package io.heynow.eventsource.model;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Builder
public @Data class Note {
    ProcessingModel processingModel;
    Map<String, Object> payload;
}
