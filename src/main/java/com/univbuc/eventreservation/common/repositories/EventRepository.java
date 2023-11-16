package com.univbuc.eventreservation.common.repositories;

import java.util.List;

import com.univbuc.eventreservation.admin.model.Event;

public interface EventRepository {
    Event addEvent(Event event);

    Event getEvent(int id);

    Event update(Event storedEvent);

    Event delete(int id);

    List<Event> getEvents();
}
