package cookcollab.com.cookcollab.data.repo;

import cookcollab.com.cookcollab.data.entity.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.sql.Date;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByEventDate(Date EventDate);
    Event findByEventID(long eventID);
    Event findByUserID(long userID);
}
