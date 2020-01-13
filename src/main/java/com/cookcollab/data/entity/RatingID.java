package com.cookcollab.data.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RatingID implements Serializable {

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JsonSerialize(using = UserSerializer.class)
	@JoinColumn(name = "reviewer_id")
	private User reviewer;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JsonSerialize(using = UserSerializer.class)
	@JoinColumn(name = "user_id")
	private User user;

	public long getReviewerID() {
		return reviewer.getUserID();
	}

	public long getUserID() {
		return user.getUserID();
	}

	public RatingID(User reviewer, User user) {
		this.reviewer = reviewer;
		this.user = user;
	}

	public RatingID() {
	}

	@Override
	public String toString() {
		return "RatingID{" +
				"reviewerID=" + reviewer.getUserID() +
				", userID=" + user.getUserID() +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RatingID)) return false;
		RatingID ratingID = (RatingID) o;
		return getReviewerID() == ratingID.getReviewerID() &&
				getUserID() == ratingID.getUserID();
	}

	@Override
	public int hashCode() {
		return Objects.hash(getReviewerID(), getUserID());
	}
}
