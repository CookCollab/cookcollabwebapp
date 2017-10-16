/*
* This file is used for the invites in our database
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.data.entity;

import javax.persistence.*;

@Entity
@Table(name="invite")
public class Invite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="invite_id")
	private long inviteID;

	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	@Column(name="viewed")
	private boolean viewed;

	@Column(name="from_event_owner")
	private boolean fromEventOwner;

	@Column(name="accepted")
	private boolean accepted;

	public long getInviteID() {
		return inviteID;
	}

	public void setInviteID(long inviteID) {
		this.inviteID = inviteID;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isViewed() {
		return viewed;
	}

	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	public boolean isFromEventOwner() {
		return fromEventOwner;
	}

	public void setFromEventOwner(boolean fromEventOwner) {
		this.fromEventOwner = fromEventOwner;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
}
