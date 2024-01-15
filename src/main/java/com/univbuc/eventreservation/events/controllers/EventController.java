package com.univbuc.eventreservation.events.controllers;

import java.util.List;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.common.model.EventTicket;
import com.univbuc.eventreservation.events.model.EventSelected;
import com.univbuc.eventreservation.events.services.EventService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController("/events")
public class EventController {
    EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public ResponseEntity<List<Event>> listEvents(){
        return ResponseEntity.ok(eventService.getEvents());
    }

    @PostMapping("/select")
    public ResponseEntity<EventTicket> selectEvent(@RequestHeader(name = "userToken") String token,
            @RequestBody EventSelected eventSelected){
        return ResponseEntity.ok(eventService.selectEvent(token, eventSelected));
    }

    @PatchMapping("/confirm")
    public ResponseEntity<EventTicket> checkout(@RequestHeader(name = "userToken") String token,
            @Valid @RequestBody EventTicket eventTicket){
        return ResponseEntity.ok(eventService.confirmEvent(token, eventTicket));
    }
}
