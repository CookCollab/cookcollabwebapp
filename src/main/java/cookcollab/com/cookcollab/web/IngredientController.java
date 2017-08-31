package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.Ingredient;
import cookcollab.com.cookcollab.data.repo.IngredientRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {

    private IngredientRepository ingredientRepo;

    @Autowired
    public IngredientController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ingredient/{id}")
    public Ingredient getIngredient(@PathVariable(value="id") long id){
        return ingredientRepo.findByIngredientID(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ingredient")
    public List<Ingredient> getAllIngredients(){
        return (List<Ingredient>) ingredientRepo.findAll();
    }
}