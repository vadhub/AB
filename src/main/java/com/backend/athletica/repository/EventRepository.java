package com.backend.athletica.repository;

import com.backend.athletica.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = EventWithSlotProjection.class)
public interface EventRepository extends JpaRepository<Event, Long> {
}
