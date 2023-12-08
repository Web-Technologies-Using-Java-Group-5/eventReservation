package com.univbuc.eventreservation.common.repositories;

import java.util.List;

import com.univbuc.eventreservation.admin.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepositoryJPA extends JpaRepository<Event, Integer> {
    @Query("select e from Event e where e.active = true order by e.capacity desc")
    public List<Event> getEvents();
}
