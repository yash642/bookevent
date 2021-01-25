package com.cg.bookevent.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookevent.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}
