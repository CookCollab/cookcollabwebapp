/*
* This class defines the routes used to perform CRUD operations on Users
* Author: Vatsal Vora
* Date: 8/31/2017
*/

package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.Rating;
import cookcollab.com.cookcollab.data.repo.RatingRepository;
import cookcollab.com.cookcollab.data.entity.User;
import cookcollab.com.cookcollab.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RatingWebController {
	private RatingRepository ratingRepo;

	@Autowired
	public RatingWebController(RatingRepository ratingRepo) {
		this.ratingRepo = ratingRepo;
	}

	@RequestMapping(method= RequestMethod.GET,value="/ratings")
	public String getReservations(Model model){
		List<Rating> ratingList = (List<Rating>) ratingRepo.findAll();
		model.addAttribute("ratings", ratingList);
		return "ratings";
	}
}
