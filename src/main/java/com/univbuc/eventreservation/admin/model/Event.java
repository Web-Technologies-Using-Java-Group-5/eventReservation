package com.univbuc.eventreservation.admin.model;

import java.util.Objects;

public class Event {
    private int id;
    private String name;
    private String description;
    private int capacity;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean active = true;

    public Event() {
    }

    public Event(int id, String name, String description, int capacity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id && capacity == event.capacity && Objects.equals(name, event.name) && Objects.equals(
                description, event.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, capacity);
    }
}
