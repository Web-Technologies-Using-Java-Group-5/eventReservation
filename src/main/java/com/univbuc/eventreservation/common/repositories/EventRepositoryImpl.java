package com.univbuc.eventreservation.common.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.univbuc.eventreservation.admin.model.Event;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl implements EventRepository {
    Set<Event> events = new HashSet<>();
    int id = 0;
    @Override
    public Event addEvent(Event event) {
        Event e = new Event(id++, event.getName(), event.getDescription(), event.getCapacity());
        events.add(e);
        return e;
    }

    @Override
    public Event getEvent(int id) {
        return events.stream().filter(event -> id == event.getId())
                .findFirst().orElseThrow();
    }

    @Override
    public Event update(Event newEvent) {
        Event e = getEvent(newEvent.getId());
        e.setName(newEvent.getName());
        e.setDescription(newEvent.getDescription());
        e.setCapacity(newEvent.getCapacity());
        return e;
    }

    @Override
    public Event delete(int id) {
        Event e = getEvent(id);
        e.setActive(false);
        return e;
    }

    @Override
    public List<Event> getEvents() {
        return events.stream().toList();
    }
}
