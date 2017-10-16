/*
* This file is used for the users in our database
* Author: Vatsal Vora
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;

import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="`user`")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userID;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;

	@Column(name="phone")
	private String phone;

	@Column(name="bio")
	private String bio;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Event> hostEvents;

	@ManyToMany(mappedBy = "guests", fetch = FetchType.LAZY)
	private List<Event> guestEvents;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Ingredient> ingredients;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Rating> ratings;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@Where(clause = "accepted = false OR viewed = false")
	private List<Invite> invites;

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Event> getHostEvents() {
		return hostEvents;
	}

	public void setHostEvents(List<Event> hostEvents) {
		this.hostEvents = hostEvents;
	}

	public List<Event> getGuestEvents() {
		return guestEvents;
	}

	public void setGuestEvents(List<Event> guestEvents) {
		this.guestEvents = guestEvents;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Invite> getInvites() {
		return invites;
	}

	public void setInvites(List<Invite> invites) {
		this.invites = invites;
	}

	// UNTESTED
	public void review(User user, int score){
		Rating rating = new Rating();
		rating.setRating(score);
		rating.setUser(user);
		rating.setReviewer(this);
		rating.setDateUpdated(LocalDate.now());
	}

	public float getRating(){
		int sum = 0;
		float toReturn = 0F;
		for(Rating rating : this.ratings){
			sum += rating.getRating();
		}
		if(!this.ratings.isEmpty()){
			toReturn = (float) sum/this.ratings.size();
		}
		return toReturn;
	}

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
}
