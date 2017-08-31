package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.User;
import cookcollab.com.cookcollab.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    private UserRepository userRepo;

    @Autowired
    public UserRestController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/user/{id}")
    public User getUser(@PathVariable(value="id") long id){
        return userRepo.findByUserID(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/api/user")
    public List<User> getAllUsers(){
        return (List<User>) userRepo.findAll();
    }
}
