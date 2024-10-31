package com.backend.athletica.controller;

import com.backend.athletica.entity.ResponseMessage;
import com.backend.athletica.entity.Subscription;
import com.backend.athletica.entity.SubscriptionEmbeddedID;
import com.backend.athletica.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api-v1")
public class SubscriptionController {
    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionController(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @GetMapping("/subscribers")
    public List<Subscription> getSubscribers(@Param("userId") Long userId) {
        return subscriptionRepository.findAll().stream().filter(follow -> Objects.equals(follow.getSubscriptionEmbeddedID().getSpotId(), userId)).toList();
    }

    @GetMapping("/is_subscriber")
    public boolean isSubscriber(@Param("userId") Long userId, @Param("spotId") Long spotId) {
        return subscriptionRepository.findById(new SubscriptionEmbeddedID(userId, spotId)).isPresent();
    }

    @PostMapping("/subscribe")
    public ResponseEntity<Object> addLike(@RequestBody SubscriptionEmbeddedID followEmbeddedID) {
        String messageResponse = "";

        try {
            return ResponseEntity.status(HttpStatus.OK).body(subscriptionRepository.save(new Subscription(followEmbeddedID)));
        } catch (Exception e) {
            messageResponse = "Could not save: " + followEmbeddedID + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(messageResponse));
        }
    }

    @DeleteMapping("/unsubscribe")
    public String deleteLike(@RequestBody SubscriptionEmbeddedID followEmbeddedID) {
        subscriptionRepository.delete(new Subscription(followEmbeddedID));

        return "remove " + followEmbeddedID;
    }
}
