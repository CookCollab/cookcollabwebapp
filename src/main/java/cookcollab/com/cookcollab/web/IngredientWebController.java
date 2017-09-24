/*
* This class defines the routes used to perform CRUD operations on Ingredients
* Author: Michael Correia
* Date: 9/24/2017
*/

package cookcollab.com.cookcollab.web;

import cookcollab.com.cookcollab.data.entity.Ingredient;
import cookcollab.com.cookcollab.data.repo.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IngredientWebController {
	private IngredientRepository ingredientRepo;

	@Autowired
	public IngredientWebController(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}

	@RequestMapping(method= RequestMethod.GET,value="/ingredients")
	public String getReservations(Model model){
		List<Ingredient> ingredientList = (List<Ingredient>) ingredientRepo.findAll();
		model.addAttribute("ingredients", ingredientList);
		return "ingredients";
	}
}
