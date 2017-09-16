/*
* This file is used for the events in our database
* Author: Michael Correia
* Date: 8/31/2017
*/

package cookcollab.com.cookcollab.data.entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="event_id")
	private long eventID;

	@Column(name="event_date")
	private Date eventDate;

	@Column(name="address")
	private String address;

	@Column(name="recipe")
	private String recipe;

	@Column(name="user_id")
	private long userID;

	public long getEventID() {
		return this.eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public Date getDate() {
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

	public long getUserID() {
		return this.userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

}
