package com.univbuc.eventreservation.common.repositories;

import java.util.Optional;

import com.univbuc.eventreservation.common.model.EventTicket;
import com.univbuc.eventreservation.users.model.User;

public interface EventTicketRepository {
    EventTicket save(EventTicket eventTicket);
    Optional<EventTicket> findById(Integer id);

    Optional<EventTicket> findByUser(User user);
}
