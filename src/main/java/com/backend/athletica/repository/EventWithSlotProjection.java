package com.backend.athletica.repository;

import com.backend.athletica.entity.Event;
import com.backend.athletica.entity.TimeSlot;
import com.backend.athletica.entity.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "spotWithSlots", types = Event.class)
interface EventWithSlotProjection {
    Long getId();

    TimeSlot getTimeSlotOne();

    String getName();

    int getParticipantLimit();

    String getDescription();
}
