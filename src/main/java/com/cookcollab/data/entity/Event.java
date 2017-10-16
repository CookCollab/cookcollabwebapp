/*
* This file is used for the events in our database
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;

import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private long eventID;

	@Column(name="event_date")
	private LocalDate eventDate;

	@Column(name="address")
	private String address;

	@Column(name="recipe")
	private String recipe;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="invite",
		joinColumns = {@JoinColumn(name="event_id", referencedColumnName = "event_id")},
		inverseJoinColumns = {@JoinColumn(name="user_id", referencedColumnName = "user_id")}
	)
	@WhereJoinTable(clause = "accepted = true")
	private List<User> guests;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "event")
	private List<Ingredient> ingredients;

	public long getEventID() {
		return this.eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public LocalDate getEventDate() {
		return this.eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRecipe() {
		return this.recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getGuests() {
		return this.guests;
	}

	public void setGuests(List<User> guests) {
		this.guests = guests;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "Event{" +
				"eventID='" + eventID + '\'' +
				", eventDate=" + eventDate +
				", address='" + address + '\'' +
				", recipe='" + recipe + '\'' +
				", user=" + user +
				'}';
	}
}
