package cookcollab.com.cookcollab.data.repo;

import cookcollab.com.cookcollab.data.entity.Invite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InviteRepository extends CrudRepository<Invite, Long> {
    List<Invite> findByEventID(long eventID);
    Invite findByInviteID(long inviteID);
}
