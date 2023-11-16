package com.univbuc.eventreservation.events.repositories;

import java.util.ArrayList;
import java.util.List;

import com.univbuc.eventreservation.events.model.EventSelected;
import org.springframework.stereotype.Repository;

@Repository
public class EventSelectionRepositoryImpl implements EventSelectionRepository {
    List<EventSelected> eventSelections = new ArrayList<>();
    int id = 0;

    @Override
    public EventSelected selectEvent(EventSelected eventSelected) {
        EventSelected eventSelectionToAdd = new EventSelected(id++, eventSelected.userId(), eventSelected.eventId(),
                eventSelected.status());
        eventSelections.add(eventSelectionToAdd);
        return eventSelectionToAdd;
    }

    @Override
    public EventSelected save(EventSelected eventSelectedToSave) {
        EventSelected e = eventSelections.stream().filter(event -> event.id() == eventSelectedToSave.id()).findFirst().orElseThrow();
        eventSelections.remove(e);
        eventSelections.add(eventSelectedToSave);
        return eventSelectedToSave;
    }
}
