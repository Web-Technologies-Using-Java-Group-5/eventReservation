package com.univbuc.eventreservation.common.repositories;

import java.util.List;
import java.util.Optional;

import com.univbuc.eventreservation.admin.model.Event;

public interface EventRepository {
    Event save(Event event);

    Optional<Event> findById(int id);

    Event update(Event storedEvent);

    void deleteById(int id);

    List<Event> getEvents();
}
