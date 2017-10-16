/*
* This class defines the routes used to perform CRUD operations on Users
* Author: Michael Correia
* Date: 9/24/2017
*/

package com.cookcollab.web;

import com.cookcollab.data.entity.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RatingWebController {

	private RatingRESTController ratingRESTController;

	@Autowired
	public RatingWebController(RatingRESTController ratingRESTController) {
		this.ratingRESTController = ratingRESTController;
	}

	@RequestMapping(method= RequestMethod.GET,value="/ratings")
	public String getRatings(Model model){
		List<Rating> ratingList = this.ratingRESTController.getAllRatings();
		model.addAttribute("ratings", ratingList);
		return "ratings";
	}

	@RequestMapping(method= RequestMethod.GET,value="/ratings/{id}")
	public String getRating(Model model, @PathVariable(value="id") long id){
		model.addAttribute("rating", this.ratingRESTController.getRating(id));
		return "rating-view";
	}
}
