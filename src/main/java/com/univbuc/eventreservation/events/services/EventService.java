package com.univbuc.eventreservation.events.services;

import java.util.List;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.events.model.EventSelected;

public interface EventService {
    List<Event> getEvents();

    EventSelected selectEvent(String token, EventSelected eventSelected);

    EventSelected confirmEvent(String token, EventSelected eventSelected);
}
