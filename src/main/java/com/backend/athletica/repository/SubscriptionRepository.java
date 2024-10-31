package com.backend.athletica.repository;

import com.backend.athletica.entity.Subscription;
import com.backend.athletica.entity.SubscriptionEmbeddedID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, SubscriptionEmbeddedID> {
}
