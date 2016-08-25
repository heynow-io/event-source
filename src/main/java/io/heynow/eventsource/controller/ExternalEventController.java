package io.heynow.eventsource.controller;

import io.heynow.eventsource.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExternalEventController {

    @RequestMapping(value = "/event", method = RequestMethod.POST)
    public ResponseEntity<String> event(@RequestBody Event event) {
        // TODO create
        return new ResponseEntity<String>(HttpStatus.OK);
    }
}
