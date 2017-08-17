package cookcollab.com.cookcollab.data.repo;

import cookcollab.com.cookcollab.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstName);
    User findByUserID(long userID);
}
