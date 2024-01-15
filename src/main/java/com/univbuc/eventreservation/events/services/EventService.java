package com.univbuc.eventreservation.events.services;

import java.util.List;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.common.model.EventTicket;
import com.univbuc.eventreservation.events.model.EventSelected;

public interface EventService {
    List<Event> getEvents();

    EventTicket selectEvent(String token, EventSelected eventSelected);

    EventTicket confirmEvent(String token, EventTicket eventTicket);
}
