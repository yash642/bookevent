package com.cg.bookevent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Food {
	@Id
	@SequenceGenerator(name = "food_id_sequence", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "food_id_sequence", strategy = GenerationType.SEQUENCE)
	@Min(1)
	@Max(999)
	private Long foodId;

	
	@Size(min = 4, max = 50, message = "Enter Valid Name")
	private String name;

	
	private double price;

	
	private String type;

	
	private String category;

	

	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Food(@Size(min = 4, max = 50, message = "Enter Valid Name") String name, double price, String type,
			String category) {
		super();
		this.name = name;
		this.price = price;
		this.type = type;
		this.category = category;
	}



	public Long getFoodId() {
		return foodId;
	}



	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", name=" + name + ", price=" + price + ", type=" + type + ", category="
				+ category + "]";
	}


	
}
