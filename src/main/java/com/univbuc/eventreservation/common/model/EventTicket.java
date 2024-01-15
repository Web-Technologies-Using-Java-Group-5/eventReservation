package com.univbuc.eventreservation.common.model;

import java.util.Objects;

import com.univbuc.eventreservation.admin.model.Event;
import com.univbuc.eventreservation.events.model.ReservationStatus;
import com.univbuc.eventreservation.users.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class EventTicket {
    @Id
    @NotNull
    @Min(value = 1)
    @GeneratedValue
    private Integer id;

    @OneToOne
    @NotNull
    @PrimaryKeyJoinColumn(name = "user_id")
    @JoinTable(name = "users")
    private User user;

    @OneToOne
    @NotNull
    @PrimaryKeyJoinColumn(name = "event_id")
    private Event event;

    @Enumerated
    @NotNull
    private ReservationStatus status;

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public EventTicket() {
    }

    public EventTicket(Integer id, User customer, Event event, ReservationStatus status) {
        this.id = id;
        this.user = customer;
        this.event = event;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getCustomer() {
        return user;
    }

    public void setCustomer(User customer) {
        this.user = customer;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventTicket that = (EventTicket) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(event,
                that.event);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, event);
    }

    @Override
    public String toString() {
        return "EventTicket{" +
                "id=" + id +
                ", customer=" + user +
                ", event=" + event +
                '}';
    }
}
