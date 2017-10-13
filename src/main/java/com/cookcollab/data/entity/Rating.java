/*
* This file is used for the ratings in our database
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="rating")
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rating_id")
	private long ratingID;

	@ManyToOne
	@JoinColumn(name="reviewer_id")
	private User reviewer;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	@Column(name="rating")
	private int rating;

	@Column(name="date_updated")
	private Date dateUpdated;

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

	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

}
