/*
* This class defines the routes used to perform CRUD operations on Invites
* Author: Michael Correia
* Date: 9/24/2017
*/

package com.cookcollab.web;

import com.cookcollab.data.entity.Invite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class InviteWebController {

	private InviteRESTController inviteRESTController;

	@Autowired
	public InviteWebController(InviteRESTController inviteRESTController) {
		this.inviteRESTController = inviteRESTController;
	}

	@RequestMapping(method= RequestMethod.GET,value="/invites")
	public String getInvites(Model model){
		List<Invite> inviteList = this.inviteRESTController.getAllInvites();
		model.addAttribute("invites", inviteList);
		return "invites";
	}

	@RequestMapping(method= RequestMethod.GET,value="/invites/{id}")
	public String getInvite(Model model, @PathVariable(value="id") long id){
		model.addAttribute("invite", this.inviteRESTController.getInvite(id));
		return "invite-view";
	}

}
