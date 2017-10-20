/*
* This file is used for the ratings in our database
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import javax.persistence.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="rating")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rating_id")
	private long ratingID;

	@ManyToOne
	@JoinColumn(name="reviewer_id")
	@JsonSerialize(using = UserSerializer.class)
	private User reviewer;

	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonSerialize(using = UserSerializer.class)
	private User user;

	@Column(name="rating")
	private int rating;

	@Column(name="date_updated")
	private LocalDate dateUpdated;

	public long getRatingID() {
		return this.ratingID;
	}

	public void setRatingID(long ratingID) {
		this.ratingID = ratingID;
	}

	public User getReviewer() {
		return this.reviewer;
	}

	public void setReviewer(User reviewer) {
		this.reviewer = reviewer;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getRating() {
		return this.rating;
	}

	public void setRating(int rating) {
		if(rating >= 0 && rating <= 5) {
			this.rating = rating;
		}
	}

	public LocalDate getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(LocalDate dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}


class RatingSerializer extends StdSerializer<Rating> {
	public RatingSerializer(){
		this(Rating.class);
	}

	public RatingSerializer(Class<Rating> rating) {
		super(rating);
	}

	@Override
	public void serialize(Rating rating, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeNumberField("ratingID", rating.getRatingID());
		generator.writeNumberField("userID", rating.getUser().getUserID());
		generator.writeNumberField("reviewerID", rating.getReviewer().getUserID());
		generator.writeNumberField("rating", rating.getRating());
		generator.writeStringField("dateUpdated", rating.getDateUpdated().toString());
		generator.writeEndObject();
	}

}

class RatingListSerializer extends StdSerializer<List<Rating>>{

	public RatingListSerializer() {
		this(null);
	}

	public RatingListSerializer(Class<List<Rating>> ratingList) {
		super(ratingList);
	}

	@Override
	public void serialize(List<Rating> ratings, JsonGenerator generator, SerializerProvider provider)throws IOException, JsonProcessingException {
		generator.writeStartArray();
		for (Rating rating : ratings) {
			generator.writeStartObject();
			generator.writeNumberField("ratingID", rating.getRatingID());
			generator.writeNumberField("userID", rating.getUser().getUserID());
			generator.writeNumberField("reviewerID", rating.getReviewer().getUserID());
			generator.writeNumberField("rating", rating.getRating());
			generator.writeStringField("dateUpdated", rating.getDateUpdated().toString());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
