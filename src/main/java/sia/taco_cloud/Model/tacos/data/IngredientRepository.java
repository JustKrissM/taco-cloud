package sia.taco_cloud.Model.tacos.data;


 
import java.util.Optional;

import sia.taco_cloud.Model.tacos.Ingredient;


 
public interface IngredientRepository {
 
  Iterable<Ingredient> findAll();
  
  Optional<Ingredient> findById(String id);
  
  Ingredient save(Ingredient ingredient);
  
}