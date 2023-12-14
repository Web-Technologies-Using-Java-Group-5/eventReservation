package com.univbuc.eventreservation.events.services;

import java.util.List;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.common.model.EventTicket;
import com.univbuc.eventreservation.common.repositories.EventRepository;
import com.univbuc.eventreservation.common.repositories.EventTicketRepository;
import com.univbuc.eventreservation.events.model.EventSelected;
import com.univbuc.eventreservation.events.model.ReservationStatus;
import com.univbuc.eventreservation.users.model.User;
import com.univbuc.eventreservation.users.repositories.UserRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final EventTicketRepository eventTicketRepository;

    private final UserRepository userRepository;

    public EventServiceImpl(EventRepository eventRepository, EventTicketRepository eventTicketRepository, UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.eventTicketRepository = eventTicketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.getEvents();
    }

    @Override
    public EventTicket selectEvent(String token, EventSelected eventSelected) {
        verifyUser(token);
        Event eventToBook = eventRepository.findById(eventSelected.eventId()).orElseThrow();
        eventToBook.setCapacity(eventToBook.getCapacity() - 1);
        eventRepository.save(eventToBook);
        User customer = userRepository.findById(eventSelected.userId()).orElseThrow();
        EventTicket eventTicketToSave = new EventTicket(null, customer, eventToBook, ReservationStatus.SELECTED);
        return eventTicketRepository.save(eventTicketToSave);
    }

    private static void verifyUser(String token) {
        if (token == null || Strings.isBlank(token)){
            throw new RuntimeException("User not logged in");
        }
    }

    @Override
    public EventTicket confirmEvent(String token, EventTicket eventTicket) {
        verifyUser(token);
        eventTicket.setStatus(ReservationStatus.CONFIRMED);
        return eventTicketRepository.save(eventTicket);
    }
}
