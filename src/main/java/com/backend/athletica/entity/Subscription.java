package com.backend.athletica.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscription")
public class Subscription {

    @EmbeddedId
    private SubscriptionEmbeddedID subscriptionEmbeddedID;

    public Subscription() {
    }

    public Subscription(SubscriptionEmbeddedID subscriptionEmbeddedID) {
        this.subscriptionEmbeddedID = subscriptionEmbeddedID;
    }

    public SubscriptionEmbeddedID getSubscriptionEmbeddedID() {
        return subscriptionEmbeddedID;
    }

    public void setSubscriptionEmbeddedID(SubscriptionEmbeddedID subscriptionEmbeddedID) {
        this.subscriptionEmbeddedID = subscriptionEmbeddedID;
    }
}
