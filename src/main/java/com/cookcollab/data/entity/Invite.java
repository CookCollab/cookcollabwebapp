/*
* This file is used for the invites in our database
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
import java.util.List;

@Entity
@Table(name="invite")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Invite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="invite_id")
	private long inviteID;

	@ManyToOne
	@JoinColumn(name="event_id")
	@JsonSerialize(using = EventSerializer.class)
	private Event event;

	@ManyToOne
	@JoinColumn(name="user_id")
	@JsonSerialize(using = UserSerializer.class)
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

class InviteSerializer extends StdSerializer<Invite> {
	public InviteSerializer(){
		this(Invite.class);
	}

	public InviteSerializer(Class<Invite> invite) {
		super(invite);
	}

	@Override
	public void serialize(Invite invite, JsonGenerator generator, SerializerProvider provider) throws IOException, JsonProcessingException {
		generator.writeStartObject();
		generator.writeNumberField("inviteID", invite.getInviteID());
		generator.writeNumberField("userID", invite.getUser().getUserID());
		generator.writeBooleanField("viewed", invite.isViewed());
		generator.writeBooleanField("fromEventOwner", invite.isFromEventOwner());
		generator.writeBooleanField("accepted", invite.isAccepted());
		generator.writeEndObject();
	}

}

class InviteListSerializer extends StdSerializer<List<Invite>>{

	public InviteListSerializer() {
		this(null);
	}

	public InviteListSerializer(Class<List<Invite>> inviteList) {
		super(inviteList);
	}

	@Override
	public void serialize(List<Invite> invites, JsonGenerator generator, SerializerProvider provider)throws IOException, JsonProcessingException {
		generator.writeStartArray();
		for (Invite invite : invites) {
			generator.writeStartObject();
			generator.writeNumberField("inviteID", invite.getInviteID());
			generator.writeNumberField("userID", invite.getUser().getUserID());
			generator.writeBooleanField("viewed", invite.isViewed());
			generator.writeBooleanField("fromEventOwner", invite.isFromEventOwner());
			generator.writeBooleanField("accepted", invite.isAccepted());
			generator.writeEndObject();
		}
		generator.writeEndArray();
	}
}
