/*
* This class defines the routes used to perform CRUD operations on Ratings
* Author: Michael Correia
* Date: 8/31/2017
*/

package com.cookcollab.web;

import com.cookcollab.data.entity.Rating;
import com.cookcollab.data.repo.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingRESTController {

	private RatingRepository ratingRepo;

	@Autowired
	public RatingRESTController(RatingRepository ratingRepo) {
		this.ratingRepo = ratingRepo;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/rating/{id}")
	public Rating getRating(@PathVariable(value="id") long id){
		return ratingRepo.findByRatingID(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/rating")
	public List<Rating> getAllRatings(){
		return (List<Rating>) ratingRepo.findAll();
	}
}
