package com.backend.athletica.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_event")
    private Long id;

    @Column(name = "organizer_id")
    private Long organizerId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="time_slot_id", referencedColumnName = "id_time_slot")
    @JsonBackReference
    private TimeSlot timeSlotOne;

    @Column(name="name")
    private String name;

    @Column(name="participant_limit")
    private int participantLimit;

    @Column(name="description")
    private String description;

    public Event() {
    }

    public Event(Long organizerId, TimeSlot timeSlotOne, String name, int participantLimit, String description) {
        this.organizerId = organizerId;
        this.timeSlotOne = timeSlotOne;
        this.name = name;
        this.participantLimit = participantLimit;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TimeSlot getTimeSlotOne() {
        return timeSlotOne;
    }

    public void setTimeSlotOne(TimeSlot timeSlot) {
        this.timeSlotOne = timeSlot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParticipantLimit() {
        return participantLimit;
    }

    public void setParticipantLimit(int participantLimit) {
        this.participantLimit = participantLimit;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }
}

