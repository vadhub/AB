package com.backend.athletica.repository;

import com.backend.athletica.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = SlotProjection.class)
public interface SlotRepository extends JpaRepository<TimeSlot, Long> {
}
