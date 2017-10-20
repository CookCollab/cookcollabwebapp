/*
* This file is used for the users in our database
* Author: Vatsal Vora
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.databind.SerializationFeature;

@Entity
@Table(name="`user`")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
	@JsonSerialize(using = EventListSerializer.class)
	private List<Event> hostEvents;

	@ManyToMany(mappedBy = "guests", fetch = FetchType.LAZY)
	@JsonSerialize(using = EventListSerializer.class)
	private List<Event> guestEvents;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonSerialize(using = IngredientListSerializer.class)
	private List<Ingredient> ingredients;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@JsonSerialize(using = RatingListSerializer.class)
	private List<Rating> ratings;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@Where(clause = "accepted = false OR viewed = false")
	@JsonSerialize(using = InviteListSerializer.class)
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

class UserSerializer extends StdSerializer<User>{
	public UserSerializer(){
		this(User.class);
	}

	public UserSerializer(Class<User> user) {
		super(user);
	}

	@Override
	public void serialize(User user, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeNumberField("userID", user.getUserID());
		generator.writeStringField("firstName", user.getFirstName());
		generator.writeStringField("lastName", user.getLastName());
		generator.writeEndObject();
	}
}

class UserListSerializer extends StdSerializer<List<User>>{

	public UserListSerializer() {
		this(null);
	}

	public UserListSerializer(Class<List<User>> userList) {
		super(userList);
	}

	@Override
	public void serialize(List<User> users, JsonGenerator generator, SerializerProvider provider)throws IOException, JsonProcessingException {
		generator.writeStartArray();
		for (User user : users) {
			generator.writeStartObject();
			generator.writeNumberField("userID", user.getUserID());
			generator.writeStringField("firstName", user.getFirstName());
			generator.writeStringField("lastName", user.getLastName());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
