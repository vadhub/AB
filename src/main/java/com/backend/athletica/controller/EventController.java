package com.backend.athletica.controller;

import com.backend.athletica.entity.Event;
import com.backend.athletica.entity.TimeSlot;
import com.backend.athletica.entity.User;
import com.backend.athletica.entity.UserRequest;
import com.backend.athletica.repository.EventRepository;
import com.backend.athletica.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api-v1")
public class EventController {
    private final EventRepository eventRepository;
    private final SlotRepository slotRepository;

    @Autowired
    public EventController(EventRepository eventRepository, SlotRepository slotRepository) {
        this.eventRepository = eventRepository;
        this.slotRepository = slotRepository;
    }

    @ResponseBody
    @PostMapping("/addEvent")
    public ResponseEntity<Object> registrationPage(@RequestBody Event event) {
        Event eve = null;
        try {
            TimeSlot timeSlot = slotRepository.save(event.getTimeSlotOne());
            eve = eventRepository.save(new Event(event.getOrganizerId(), timeSlot, event.getName(), event.getParticipantLimit(), event.getDescription()));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        return ResponseEntity.ok(eve);
    }
}
