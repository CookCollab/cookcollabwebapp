package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.Invite;
import cookcollab.com.cookcollab.data.repo.InviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InviteController {

    private InviteRepository inviteRepo;

    @Autowired
    public InviteController(InviteRepository inviteRepo) {
        this.inviteRepo = inviteRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/invite/{id}")
    public Invite getInvite(@PathVariable(value="id") long id){
        return inviteRepo.findByInviteID(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/invite")
    public List<Invite> getAllInvite(){
        return (List<Invite>) inviteRepo.findAll();
    }
}
