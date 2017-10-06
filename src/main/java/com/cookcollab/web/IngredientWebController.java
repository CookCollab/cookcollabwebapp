/*
* This class defines the routes used to perform CRUD operations on Ingredients
* Author: Michael Correia
* Date: 9/24/2017
*/

package com.cookcollab.web;

import com.cookcollab.data.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IngredientWebController {

	private IngredientRESTController ingredientRESTController;

	@Autowired
	public IngredientWebController(IngredientRESTController ingredientRESTController) {
		this.ingredientRESTController = ingredientRESTController;
	}

	@RequestMapping(method= RequestMethod.GET,value="/ingredients")
	public String getIngredients(Model model){
		List<Ingredient> ingredientList = this.ingredientRESTController.getAllIngredients();
		model.addAttribute("ingredients", ingredientList);
		return "ingredients";
	}

	@RequestMapping(method= RequestMethod.GET,value="/ingredients/{id}")
	public String getIngredient(Model model, @PathVariable(value="id") long id){
		model.addAttribute("ingredient", this.ingredientRESTController.getIngredient(id));
		return "ingredient-view";
	}
}
