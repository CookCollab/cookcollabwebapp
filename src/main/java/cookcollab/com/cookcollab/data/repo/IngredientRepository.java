package cookcollab.com.cookcollab.data.repo;

import cookcollab.com.cookcollab.data.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    List<Ingredient> findByName(String name);
	Ingredient findByIngredientID(long ingredientID);
    Ingredient findByEventID(long eventID);
    Ingredient findByUserID(long userID);
}