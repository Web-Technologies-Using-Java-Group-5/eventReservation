package com.univbuc.eventreservation.common.repositories;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.univbuc.eventreservation.admin.exceptions.EventAlreadyRegistered;
import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.common.exceptions.DatabaseError;
import org.springframework.stereotype.Repository;

@Repository
public class EventRepositoryImpl implements EventRepository {
    Set<Event> events = new HashSet<>();
    int id = 0;
    @Override
    public Event save(Event event) {
        checkDatabase();
        if (events.stream().anyMatch(e -> e.getName().equals(event.getName()))) throw new EventAlreadyRegistered("Event already "
                + "registered");
        Event e = new Event(id++, event.getName(), event.getDescription(), event.getCapacity());
        events.add(e);
        return e;
    }

    private void checkDatabase() {
        if (events == null) throw new DatabaseError("Connection failed!");
    }

    @Override
    public Optional<Event> findById(int id) {
        checkDatabase();
        return events.stream().filter(event -> id == event.getId())
                .findFirst();
    }

    @Override
    public Event update(Event newEvent) {
        Event e = findById(newEvent.getId()).orElseThrow();
        e.setName(newEvent.getName());
        e.setDescription(newEvent.getDescription());
        e.setCapacity(newEvent.getCapacity());
        return e;
    }

    @Override
    public void deleteById(int id) {
        Event e = findById(id).orElseThrow();
        e.setActive(false);
    }

    @Override
    public List<Event> getEvents() {
        return events.stream().toList();
    }
}
