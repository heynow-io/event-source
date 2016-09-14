package io.heynow.eventsource.service;

import io.heynow.eventsource.model.Event;
import io.heynow.eventsource.model.Note;
import io.heynow.eventsource.model.ProcessingModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@EnableBinding({Sink.class, Source.class})
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class EventService {

    private final StreamManagerService streamManagerService;
    private final Source source;

    public void processEvent(Event event) {
        List<ProcessingModel> processingModels = streamManagerService.fetchProcessingModels(event.getSource(), event.getType());

        for (ProcessingModel processingModel : processingModels) {
            sendEventToRouter(event, processingModel);
        }
    }

    private void sendEventToRouter(Event event, ProcessingModel processingModel) {
        Note note = prepareNote(event, processingModel);
        source.output().send(MessageBuilder.withPayload(note).build());
    }

    private Note prepareNote(Event event, ProcessingModel processingModel) {
        return Note.builder().processingModel(processingModel).payload(event.getPayload()).build();
    }

    @org.springframework.integration.annotation.Router(inputChannel = Sink.INPUT)
    public final String route(Note note) {
        return note.getProcessingModel().getCurrent().getName();
    }

}
