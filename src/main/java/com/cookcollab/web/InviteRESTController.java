/*
* This class defines the routes used to perform CRUD operations on Invites
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.web;

import com.cookcollab.data.entity.Invite;
import com.cookcollab.data.repo.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InviteRESTController {

	private InviteRepository inviteRepo;

	@Autowired
	public InviteRESTController(InviteRepository inviteRepo) {
		this.inviteRepo = inviteRepo;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/invite/{id}")
	public Invite getInvite(@PathVariable(value="id") long id){
		return inviteRepo.findByInviteID(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/invite")
	public List<Invite> getAllInvites(){
		return (List<Invite>) inviteRepo.findAll();
	}
}
