package io.heynow.eventsource.model;

import lombok.Data;

import java.util.Map;

public
@Data
class ExternalEvent {
    String url;
    String eventType;
    String application;
    Map<String, String> payload;
}
