package com.backend.athletica.repository;

import com.backend.athletica.entity.Review;
import com.backend.athletica.entity.TimeSlot;
import com.backend.athletica.entity.Spot;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "spotWithSlots", types = Spot.class)
public interface SpotWithSlotsProjection {
    Long getId();
    String getName();
    String getLat();
    String getLon();
    String getDescription();
    String getAddress();
    List<Review> getReviews();
    List<TimeSlot> getTimeSlots();
}
