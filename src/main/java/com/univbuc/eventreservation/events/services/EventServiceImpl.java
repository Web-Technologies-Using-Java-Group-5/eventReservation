package com.univbuc.eventreservation.events.services;

import java.util.List;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.common.repositories.EventRepository;
import com.univbuc.eventreservation.common.repositories.EventRepositoryJPA;
import com.univbuc.eventreservation.events.model.EventSelected;
import com.univbuc.eventreservation.events.model.ReservationStatus;
import com.univbuc.eventreservation.events.repositories.EventSelectionRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepositoryJPA eventRepository;
    private final EventSelectionRepository eventSelectionRepository;

    public EventServiceImpl(EventRepositoryJPA eventRepository, EventSelectionRepository eventSelectionRepository) {
        this.eventRepository = eventRepository;
        this.eventSelectionRepository = eventSelectionRepository;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.getEvents();
    }

    @Override
    public EventSelected selectEvent(String token, EventSelected eventSelected) {
        verifyUser(token);
        EventSelected eventSelectedToSave = new EventSelected(eventSelected.id(), eventSelected.userId(), eventSelected.eventId(),
                ReservationStatus.SELECTED);
        return eventSelectionRepository.selectEvent(eventSelectedToSave);
    }

    private static void verifyUser(String token) {
        if (token == null || Strings.isBlank(token)){
            throw new RuntimeException("User not logged in");
        }
    }

    @Override
    public EventSelected confirmEvent(String token, EventSelected eventSelected) {
        verifyUser(token);
        EventSelected eventSelectedToSave = new EventSelected(eventSelected.id(), eventSelected.userId(), eventSelected.eventId(),
                ReservationStatus.CONFIRMED);
        return eventSelectionRepository.save(eventSelectedToSave);
    }
}
