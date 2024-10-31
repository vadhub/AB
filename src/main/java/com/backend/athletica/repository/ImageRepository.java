package com.backend.athletica.repository;

import com.backend.athletica.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> { }