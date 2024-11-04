package com.backend.athletica.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vote")
    private Long idVote;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "time_slot_id")
    private Long timeSlotId;

    @Column(name = "is_come")
    private int isCome;

    public Vote() {
    }

    public Vote(Long idVote, Long userId, Long timeSlotId, int isCome) {
        this.idVote = idVote;
        this.userId = userId;
        this.timeSlotId = timeSlotId;
        this.isCome = isCome;
    }

    public Long getIdVote() {
        return idVote;
    }

    public void setIdVote(Long idVote) {
        this.idVote = idVote;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(Long timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public int getIsCome() {
        return isCome;
    }

    public void setIsCome(int isCome) {
        this.isCome = isCome;
    }
}
