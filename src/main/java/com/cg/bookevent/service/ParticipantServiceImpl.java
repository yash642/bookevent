package com.cg.bookevent.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookevent.dao.ParticipantRepository;
import com.cg.bookevent.entity.Participant;
import com.cg.bookevent.exception.NoValueFoundException;
@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private ParticipantRepository participantRepository;

	@Override
	public List<Participant> fetchAllParticipants() {
		return participantRepository.findAll();
	}

	@Override
	public Participant getParticipantById(long participantId) {

		return participantRepository.findById(participantId).orElseThrow(() -> new NoValueFoundException("Participant does not exist"));
	}

	@Override
	public Participant updateParticipant(Participant participant) {
		return participantRepository.save(participant);
	}

	@Override
	public Map<String,String> addParticipant(Participant participant) {

		return Collections.singletonMap("participantId:", participantRepository.save(participant).getParticipantId().toString());
	}

}
