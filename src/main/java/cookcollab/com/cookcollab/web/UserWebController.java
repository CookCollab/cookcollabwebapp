package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.User;
import cookcollab.com.cookcollab.data.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserWebController
{
        private UserRepository userRepo;

        @Autowired
        public UserWebController(UserRepository userRepo) {
            this.userRepo = userRepo;
        }

        @RequestMapping(method= RequestMethod.GET,value="/users")
        public String getReservations(Model model){
            List<User> userList = (List<User>) userRepo.findAll();
            model.addAttribute("users", userList);
            return "users";
        }
}
