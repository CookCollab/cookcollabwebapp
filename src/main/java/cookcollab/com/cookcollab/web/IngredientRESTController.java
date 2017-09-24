/*
* This class defines the routes used to perform CRUD operations on Ingredients
* Author: Christopher Pope
* Date: 8/31/2017
*/

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
public class IngredientRESTController {

	private IngredientRepository ingredientRepo;

	@Autowired
	public IngredientRESTController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/ingredient/{id}")
	public Ingredient getIngredient(@PathVariable(value="id") long id){
		return ingredientRepo.findByIngredientID(id);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/api/ingredient")
	public List<Ingredient> getAllIngredients(){
		return (List<Ingredient>) ingredientRepo.findAll();
	}
}
