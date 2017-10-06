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

	@Column(name="event_id")
	private long eventID;

	@Column(name="user_id")
	private long userID;

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

	public long getEventID() {
		return eventID;
	}

	public void setEventID(long eventID) {
		this.eventID = eventID;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
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
