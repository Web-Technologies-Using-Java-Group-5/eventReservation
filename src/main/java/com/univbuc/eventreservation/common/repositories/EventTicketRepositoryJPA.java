package com.univbuc.eventreservation.common.repositories;

import java.util.Optional;

import com.univbuc.eventreservation.common.model.EventTicket;
import com.univbuc.eventreservation.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventTicketRepositoryJPA extends EventTicketRepository, JpaRepository<EventTicket, Integer> {
    @Override
    Optional<EventTicket> findByUser(User user);
}
