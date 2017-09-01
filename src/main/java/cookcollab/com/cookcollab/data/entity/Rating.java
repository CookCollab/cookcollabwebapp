package cookcollab.com.cookcollab.data.entity;


import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="rating")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="rating_id")
    private long ratingID;
    @Column(name="reviewer_id")
    private long reviewerID;
    @Column(name="user_id")
    private long userID;
    @Column(name="rating")
    private int rating;
    @Column(name="date_updated")
    private Date dateUpdated;

    public long getRatingID() {
        return this.ratingID;
    }

    public void setRatingID(long ratingID) {
        this.ratingID = ratingID;
    }

    public long getReviewerID() {
        return this.reviewerID;
    }

    public void setReviewerID(long reviewerID) {
        this.reviewerID = reviewerID;
    }

    public long getUserID() {
        return this.userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        if(rating >= 0 && rating <= 5) {
            this.rating = rating;
        }
    }

    public Date getDateUpdated() {
        return this.dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

}
