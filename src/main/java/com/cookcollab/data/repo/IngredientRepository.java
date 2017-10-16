/*
* This interface defines the methods used to perform CRUD operations on Ingredients
* Author: Christopher Pope
* Date: 8/31/2017
*/

package com.cookcollab.data.repo;

import com.cookcollab.data.entity.Event;
import com.cookcollab.data.entity.Ingredient;
import com.cookcollab.data.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	List<Ingredient> findByName(String name);
	Ingredient findByIngredientID(long ingredientID);
	Ingredient findByEvent(Event event);
	Ingredient findByUser(User user);
}
