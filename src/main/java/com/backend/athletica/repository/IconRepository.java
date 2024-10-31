package com.backend.athletica.repository;

import com.backend.athletica.entity.Icon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IconRepository extends JpaRepository<Icon, Long> {

    @Query("FROM Icon i WHERE i.userId = :userId")
    Optional<Icon> getIconByUserId(@Param("userId") Long userId);
}