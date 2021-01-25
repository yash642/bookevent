package com.cg.bookevent.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bookevent.entity.Participant;
import com.cg.bookevent.service.ParticipantService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/participant")
@CrossOrigin(origins = "*")
@Api(value = "Participant Service for CulturoFesto")
public class ParticipantController {

	@Autowired
	ParticipantService participantService;

	@PostMapping("/add")
	public ResponseEntity<Map<String, String>> addParticipant(@Valid @RequestBody Participant participant) {
		return ResponseEntity.status(HttpStatus.CREATED).body(participantService.addParticipant(participant));
	}

	@PutMapping("/update")
	public ResponseEntity<Participant> updateParticipant(@Valid @RequestBody Participant participant) {
		return ResponseEntity.status(HttpStatus.OK).body(participantService.updateParticipant(participant));
	}

	@GetMapping("/findall")
	public ResponseEntity<List<Participant>> fetchAllParticipants() {
		return ResponseEntity.status(HttpStatus.OK).body(participantService.fetchAllParticipants());
	}

	@GetMapping("/{participantId}")
	public ResponseEntity<Participant> getparticipantById(@Valid @PathVariable long participantId) {
		return ResponseEntity.status(HttpStatus.OK).body(participantService.getParticipantById(participantId));
	}
}
