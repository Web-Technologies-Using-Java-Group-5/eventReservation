package com.univbuc.eventreservation.events.services;

import java.util.List;
import java.util.Optional;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.common.exceptions.DatabaseError;
import com.univbuc.eventreservation.common.model.EventTicket;
import com.univbuc.eventreservation.common.repositories.EventRepository;
import com.univbuc.eventreservation.common.repositories.EventTicketRepository;
import com.univbuc.eventreservation.events.model.EventSelected;
import com.univbuc.eventreservation.events.model.ReservationStatus;
import com.univbuc.eventreservation.users.model.User;
import com.univbuc.eventreservation.users.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.w3c.dom.stylesheets.LinkStyle;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    public static final Event INPUT_EVENT = new Event(0, "event", "description", 100);
    public static final User INPUT_USER = new User(1, "testUser", "testPassword", "CUSTOMER");
    @Mock
    private EventRepository eventRepository;

    @Mock
    private EventTicketRepository eventTicketRepository;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    EventServiceImpl serviceUnderTest;

    @Test
    void getEvents() {
        List<Event> events = List.of(new Event(), new Event());
        when(eventRepository.getEvents()).thenReturn(events);

        var result = serviceUnderTest.getEvents();

        assertEquals(events, result);
        assertEquals(2, result.size());
    }

    @Test
    void getEvents_dbError() {
        List<Event> events = List.of(new Event(), new Event());
        when(eventRepository.getEvents()).thenThrow(DatabaseError.class);

        assertThrows(DatabaseError.class, ()->serviceUnderTest.getEvents());
    }

    @Test
    void selectEvent() {
        when(eventRepository.findById(anyInt())).thenReturn(Optional.of(INPUT_EVENT));
        when(eventRepository.save(INPUT_EVENT)).thenReturn(INPUT_EVENT);
        when(userRepository.findById(any())).thenReturn(Optional.of(INPUT_USER));
        when(eventTicketRepository.save(any())).thenReturn(new EventTicket());

        String token = "token";
        EventSelected inputEventSelected = new EventSelected(0, INPUT_USER.getId(), INPUT_EVENT.getId(), null);
        Event eventToBeSaved = new Event(INPUT_EVENT.getId(), INPUT_EVENT.getName(), INPUT_EVENT.getDescription(),
                INPUT_EVENT.getCapacity() - 1);

        serviceUnderTest.selectEvent(token, inputEventSelected);
        verify(eventRepository, times(1)).findById(inputEventSelected.eventId());
        verify(eventRepository, times(1)).save(eventToBeSaved);
        verify(userRepository, times(1)).findById(INPUT_USER.getId());
        verify(eventTicketRepository).save(new EventTicket(null, INPUT_USER, INPUT_EVENT, ReservationStatus.SELECTED));
    }

    @Test
    void selectEvent_saveException() {
        when(eventRepository.findById(anyInt())).thenReturn(Optional.of(INPUT_EVENT));
        when(eventRepository.save(INPUT_EVENT)).thenThrow(DatabaseError.class);

        String token = "token";
        EventSelected inputEventSelected = new EventSelected(0, INPUT_USER.getId(), INPUT_EVENT.getId(), null);
        Event eventToBeSaved = new Event(INPUT_EVENT.getId(), INPUT_EVENT.getName(), INPUT_EVENT.getDescription(),
                INPUT_EVENT.getCapacity() - 1);

        assertThrows(DatabaseError.class, ()->serviceUnderTest.selectEvent(token, inputEventSelected));
        verify(eventRepository, times(1)).findById(inputEventSelected.eventId());
        verify(eventRepository, times(1)).save(eventToBeSaved);
    }



    @Test
    void selectEvent_noEventFound() {
        when(eventRepository.findById(anyInt())).thenReturn(Optional.empty());

        String token = "token";
        EventSelected inputEventSelected = new EventSelected(0, INPUT_USER.getId(), INPUT_EVENT.getId(), null);
        Event eventToBeSaved = new Event(INPUT_EVENT.getId(), INPUT_EVENT.getName(), INPUT_EVENT.getDescription(),
                INPUT_EVENT.getCapacity() - 1);

        assertThrows(Exception.class, ()-> serviceUnderTest.selectEvent(token, inputEventSelected));
    }

    @Test
    void confirmEvent() {
    }
}