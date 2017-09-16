/*
* This class defines the routes used to perform CRUD operations on Events
* Author: Michael Correia
* Date: 8/31/2017
*/

package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.Event;
import cookcollab.com.cookcollab.data.repo.EventRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EventController {

	private EventRepository eventRepo;

	@Autowired
	public EventController(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/event/{id}")
	public Event getEvent(@PathVariable(value="id") long id){
		return eventRepo.findByEventID(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/event")
	public List<Event> getAllEvents(){
		return (List<Event>) eventRepo.findAll();
	}
}
