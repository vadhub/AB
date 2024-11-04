package com.backend.athletica.repository;

import com.backend.athletica.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    @Query("SELECT count(v.userId) FROM Vote v WHERE v.isCome = 1 AND v.timeSlotId = :slotId")
    Integer countComeUser(@Param("slotId") Long slotId);

    void deleteByUserIdAndTimeSlotId(Long userId, Long timeSlotId);

    Optional<Vote> getVoteByUserIdAndTimeSlotId(Long userId, Long timeSlotId);
}
