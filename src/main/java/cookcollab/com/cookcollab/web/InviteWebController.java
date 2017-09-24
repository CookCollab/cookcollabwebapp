/*
* This class defines the routes used to perform CRUD operations on Invites
* Author: Michael Correia
* Date: 9/24/2017
*/

package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.Invite;
import cookcollab.com.cookcollab.data.repo.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class InviteWebController {
	private InviteRepository inviteRepo;

	@Autowired
	public InviteWebController(InviteRepository inviteRepo) {
		this.inviteRepo = inviteRepo;
	}

	@RequestMapping(method= RequestMethod.GET,value="/invites")
	public String getReservations(Model model){
		List<Invite> inviteList = (List<Invite>) inviteRepo.findAll();
		model.addAttribute("invites", inviteList);
		return "invites";
	}
}
