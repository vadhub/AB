package com.backend.athletica.repository;

import com.backend.athletica.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(excerptProjection = SpotWithSlotsProjection.class)
public interface SpotRepository extends JpaRepository<Spot, Long> {
    Optional<SpotWithSlotsProjection> findByLatAndLon(String lat, String lon);
}
