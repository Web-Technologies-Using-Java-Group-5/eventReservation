package com.univbuc.eventreservation.events.model;

public record EventSelected(int id, int userId, int eventId, ReservationStatus status) {
}
