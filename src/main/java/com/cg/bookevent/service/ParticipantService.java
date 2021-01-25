package com.cg.bookevent.service;

import java.util.List;
import java.util.Map;

import com.cg.bookevent.entity.Participant;

public interface ParticipantService {

	
	List<Participant> fetchAllParticipants();
	
	Map<String, String> addParticipant(Participant participant);
	
	Participant  getParticipantById(long participantId);
	
	Participant updateParticipant(Participant participant);
}
