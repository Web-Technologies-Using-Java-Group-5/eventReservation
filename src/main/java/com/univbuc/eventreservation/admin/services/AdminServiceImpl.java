package com.univbuc.eventreservation.admin.services;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.common.repositories.EventRepository;
import com.univbuc.eventreservation.common.repositories.EventRepositoryJPA;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminServiceImpl implements AdminService {
    public AdminServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    EventRepository eventRepository;
    @Override
    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    @Transactional
    @Override
    public Event updateEvent(Event event, int id) {
        Event storedEvent = eventRepository.findById(id).orElseThrow();
        storedEvent.setName(event.getName());
        storedEvent.setDescription(event.getDescription());
        storedEvent.setCapacity(event.getCapacity());
        return eventRepository.save(storedEvent);
    }

    @Override
    public void cancelEvent(Integer id) {
        eventRepository.deleteById(id);
    }
}
