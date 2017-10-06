/*
* This class defines the API routes for an application to access the Users
* Author: Vatsal Vora
* Date: 8/31/2017
*/

package com.cookcollab.web;

import com.cookcollab.data.entity.User;
import com.cookcollab.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRESTController {

	private UserRepository userRepo;

	@Autowired
	public UserRESTController(UserRepository userRepo) {
		this.userRepo = userRepo;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/user/{id}")
	public User getUser(@PathVariable(value="id") long id){
		return userRepo.findByUserID(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/user")
	public List<User> getAllUsers(){
		return (List<User>) userRepo.findAll();
	}
}
