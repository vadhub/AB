package com.backend.athletica.entity;

import jakarta.persistence.Embeddable;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
public class SubscriptionEmbeddedID implements Serializable {

    @Serial
    private static final long serialVersionUID = 0L;

    private Long userId;
    private Long spotId;

    public SubscriptionEmbeddedID() {
    }

    public SubscriptionEmbeddedID(Long userId, Long spotId) {
        this.userId = userId;
        this.spotId = spotId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSpotId() {
        return spotId;
    }

    public void setSpotId(Long spotId) {
        this.spotId = spotId;
    }
}