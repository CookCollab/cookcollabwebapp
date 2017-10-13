/*
* This file is used for the events in our database
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;


import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import javax.validation.Constraint;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="event_id")
	private long eventID;

	@Column(name="event_date")
	private Date eventDate;

	@Column(name="address")
	private String address;

	@Column(name="recipe")
	private String recipe;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public long getEventID() {
		return this.eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public Date getEventDate() {
		return this.eventDate;
	}

	public void setDate(Date eventDate) {
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
