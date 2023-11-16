package com.univbuc.eventreservation.events.repositories;

import com.univbuc.eventreservation.events.model.EventSelected;

public interface EventSelectionRepository {
    EventSelected selectEvent(EventSelected eventSelected);

    EventSelected save(EventSelected eventSelectedToSave);
}
