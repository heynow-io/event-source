package io.heynow.eventsource.model;

import lombok.Data;

import java.util.Map;

@Data
public class Event {
    String source;
    String type;
    Map<String, Object> payload;
}
