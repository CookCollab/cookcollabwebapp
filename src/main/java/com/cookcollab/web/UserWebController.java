/*
* This class defines the routes used to perform CRUD operations on Users
* Author: Vatsal Vora
* Date: 8/31/2017
*/

package com.cookcollab.web;

import com.cookcollab.data.entity.User;
import com.cookcollab.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserWebController{
	private UserRepository userRepo;
	private UserRESTController userRESTController;

	@Autowired
	public UserWebController(UserRESTController userRESTController) {
		this.userRESTController = userRESTController;
	}

	@RequestMapping(method= RequestMethod.GET,value="/users")
	public String getUsers(Model model){
		List<User> userList = this.userRESTController.getAllUsers();
		model.addAttribute("users", userList);
		return "users";
	}

	@RequestMapping(method= RequestMethod.GET,value="/users/{id}")
	public String getUser(Model model, @PathVariable(value="id") long id){
		model.addAttribute("user", this.userRESTController.getUser(id));
		return "user-view";
	}
}
