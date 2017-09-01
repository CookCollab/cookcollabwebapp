package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.Rating;
import cookcollab.com.cookcollab.data.repo.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RatingController {

    private RatingRepository ratingRepo;

    @Autowired
    public RatingController(RatingRepository ratingRepo) {
        this.ratingRepo = ratingRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rating/{id}")
    public Rating getRating(@PathVariable(value="id") long id){
        return ratingRepo.findByRatingID(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rating")
    public List<Rating> getAllRatings(){
        return (List<Rating>) ratingRepo.findAll();
    }
}
