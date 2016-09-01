package io.heynow.eventsource.controller;

import io.heynow.eventsource.model.ExternalEvent;
import io.heynow.eventsource.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalEventController {

    @Autowired
    EventService eventService;

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public void event(@RequestBody ExternalEvent event) {
        eventService.processEvent(event);
    }
}
