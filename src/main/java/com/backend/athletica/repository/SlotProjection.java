package com.backend.athletica.repository;

import com.backend.athletica.entity.TimeSlot;
import org.springframework.data.rest.core.config.Projection;

import java.sql.Time;

@Projection(name = "slots", types = TimeSlot.class)
interface SlotProjection {
    Long getSpotId();

    Long getId();

    Time getStartTime();

    Time getEndTime();

    int getAvailability();

}
