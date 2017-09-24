/*
* This class defines the routes used to perform CRUD operations on Events
* Author: Michael Correia
* Date: 9/24/2017
*/

package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.Event;
import cookcollab.com.cookcollab.data.repo.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class EventWebController {
	private EventRepository eventRepo;

	@Autowired
	public EventWebController(EventRepository eventRepo) {
		this.eventRepo = eventRepo;
	}

	@RequestMapping(method= RequestMethod.GET,value="/events")
	public String getReservations(Model model){
		List<Event> eventList = (List<Event>) eventRepo.findAll();
		model.addAttribute("events", eventList);
		return "events";
	}
}
