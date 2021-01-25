package com.cg.bookevent.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


@Entity
public class Participant {

	@Id
	@SequenceGenerator(name = "participant_id_sequence", initialValue = 100000, allocationSize = 1)
	@GeneratedValue(generator = "participant_id_sequence", strategy = GenerationType.SEQUENCE)
//	@Min(100000)
//	@Max(999999)
	private Long participantId;
	
//	@Size(min = 5, max = 50)
	private String participantName;
	
//	@Size(min = 10, max = 10, message = "Length of phone number must be 10")
	private String participantMobileNo;
	
	private int participantAge;

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "foodId")
	private List<Food> foods;
	
	public Participant() {
		// TODO Auto-generated constructor stub
	}

	public Participant(@Size(min = 5, max = 50) String participantName,
			@Size(min = 10, max = 10, message = "Length of phone number must be 10") String participantMobileNo,
			int participantAge, List<Food> foods) {
		super();
		this.participantName = participantName;
		this.participantMobileNo = participantMobileNo;
		this.participantAge = participantAge;
		this.foods = foods;
	}

	public Long getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Long participantId) {
		this.participantId = participantId;
	}

	public String getParticipantName() {
		return participantName;
	}

	public void setParticipantName(String participantName) {
		this.participantName = participantName;
	}

	public String getParticipantMobileNo() {
		return participantMobileNo;
	}

	public void setParticipantMobileNo(String participantMobileNo) {
		this.participantMobileNo = participantMobileNo;
	}

	public int getParticipantAge() {
		return participantAge;
	}

	public void setParticipantAge(int participantAge) {
		this.participantAge = participantAge;
	}

	public List<Food> getFoods() {
		return foods;
	}

	public void setFoods(List<Food> foods) {
		this.foods = foods;
	}

	@Override
	public String toString() {
		return "Participant [participantId=" + participantId + ", participantName=" + participantName
				+ ", participantMobileNo=" + participantMobileNo + ", participantAge=" + participantAge + ", foods="
				+ foods + "]";
	}

	
}
