package com.cg.bookevent.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Event {
	@Id
	@SequenceGenerator(name = "event_id_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "event_id_sequence", strategy = GenerationType.SEQUENCE)
	
	private Long eventId;
	
	@Size(min = 4, max = 50, message = "Enter Valid Name")
	private String name;
	
	private String venue;
	
	private double price;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateFrom;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dateTo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate lastDate;
	
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "foodId")
	private List<Food> foods;

//	@ManyToOne
//	@JoinColumn(name = "foodId", referencedColumnName = "foodId", foreignKey = @ForeignKey(name = "FK_food_participant_ID"))
//	private Food food;
//	
	//private BufferedImage img;

	
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

public Event(@Size(min = 4, max = 50, message = "Enter Valid Name") String name, String venue, double price,
		LocalDate dateFrom, LocalDate dateTo, LocalDate lastDate, List<Food> foods) {
	super();
	this.name = name;
	this.venue = venue;
	this.price = price;
	this.dateFrom = dateFrom;
	this.dateTo = dateTo;
	this.lastDate = lastDate;
	this.foods = foods;
}

public Long getEventId() {
	return eventId;
}

public void setEventId(Long eventId) {
	this.eventId = eventId;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getVenue() {
	return venue;
}

public void setVenue(String venue) {
	this.venue = venue;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public LocalDate getDateFrom() {
	return dateFrom;
}

public void setDateFrom(LocalDate dateFrom) {
	this.dateFrom = dateFrom;
}

public LocalDate getDateTo() {
	return dateTo;
}

public void setDateTo(LocalDate dateTo) {
	this.dateTo = dateTo;
}

public LocalDate getLastDate() {
	return lastDate;
}

public void setLastDate(LocalDate lastDate) {
	this.lastDate = lastDate;
}

public List<Food> getFoods() {
	return foods;
}

public void setFoods(List<Food> foods) {
	this.foods = foods;
}

@Override
public String toString() {
	return "Event [eventId=" + eventId + ", name=" + name + ", venue=" + venue + ", price=" + price + ", dateFrom="
			+ dateFrom + ", dateTo=" + dateTo + ", lastDate=" + lastDate + ", foods=" + foods + "]";
}



	

	
	
	

}
