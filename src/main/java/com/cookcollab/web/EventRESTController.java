/*
* This class defines the routes used to perform CRUD operations on Events
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.web;

import com.cookcollab.data.entity.Event;
import com.cookcollab.data.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventRESTController {

	private EventRepository eventRepo;

	@Autowired
	public EventRESTController(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/event/{id}")
	public Event getEvent(@PathVariable(value="id") long id){
		return eventRepo.findByEventID(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/event")
	public List<Event> getAllEvents(){
		return (List<Event>) eventRepo.findAll();
	}
}
