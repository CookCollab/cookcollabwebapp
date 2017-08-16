package cookcollab.com.cookcollab.data.repository;

import cookcollab.com.cookcollab.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByID(long userID);
}
