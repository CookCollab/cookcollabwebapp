/*
* This file is used for the ingredients in our database
* Author: Christopher Pope
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;

import javax.persistence.*;

@Entity
@Table(name="ingredient")
public class Ingredient {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ingredient_id")
	private long ingredientID;

	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	@Column(name="quantity")
	private long quantity;
	@Column(name="unit")
	private String unit;
	@Column(name="name")
	private String name;
	 
	public long getIngredientID() {
		return this.ingredientID;
	}

	public void setIngredientID(long ingredientID) {
		this.ingredientID = ingredientID;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
