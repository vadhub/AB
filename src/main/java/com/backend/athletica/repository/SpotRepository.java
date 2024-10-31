package com.backend.athletica.repository;

import com.backend.athletica.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpotRepository extends JpaRepository<Spot, Long> {
    Optional<Spot> findByLatAndLon(String lat, String lon);
}
