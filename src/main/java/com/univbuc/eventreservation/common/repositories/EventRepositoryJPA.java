package com.univbuc.eventreservation.common.repositories;

import java.util.List;

import com.univbuc.eventreservation.admin.model.Event;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Primary
public interface EventRepositoryJPA extends JpaRepository<Event, Integer>, EventRepository {
    @Override
    @Query("select e from Event e where e.active = true order by e.capacity desc")
    List<Event> getEvents();
}
