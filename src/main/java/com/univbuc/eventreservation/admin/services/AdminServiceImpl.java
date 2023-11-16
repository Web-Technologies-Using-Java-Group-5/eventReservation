package com.univbuc.eventreservation.admin.services;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.common.repositories.EventRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    public AdminServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    EventRepository eventRepository;
    @Override
    public Event addEvent(Event event) {
        return eventRepository.addEvent(event);
    }

    @Override
    public Event updateEvent(Event event, int id) {
        var storedEvent = eventRepository.getEvent(id);
        storedEvent.setName(event.getName());
        storedEvent.setDescription(event.getDescription());
        storedEvent.setCapacity(event.getCapacity());
        return eventRepository.update(storedEvent);
    }

    @Override
    public Event cancelEvent(int id) {
        return eventRepository.delete(id);
    }
}
