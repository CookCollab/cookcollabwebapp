/*
* This interface defines the methods used to perform CRUD operations on Ratings
* Author: Michael Correia
* Date: 8/31/2017
*/

package cookcollab.com.cookcollab.data.repo;

import cookcollab.com.cookcollab.data.entity.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long> {
    List<Rating> findByReviewerID(long reviewerID);
	Rating findByDateUpdated(Date dateUpdated);
	Rating findByRatingID(long userID);
	Rating findByUserID(long userID);
}
