/*
* This interface defines the methods used to perform CRUD operations on Invites
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.data.repo;

import com.cookcollab.data.entity.Invite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InviteRepository extends CrudRepository<Invite, Long> {
	List<Invite> findByEventID(long eventID);
	Invite findByInviteID(long inviteID);
}
