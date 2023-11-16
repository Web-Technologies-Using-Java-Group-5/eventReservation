package com.univbuc.eventreservation.admin.services;

import com.univbuc.eventreservation.admin.model.Event;

public interface AdminService {
    Event addEvent(Event event);
    Event updateEvent(Event event, int id);
    Event cancelEvent(int id);
}
