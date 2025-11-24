package sia.taco_cloud.Model.tacos.data;

import org.springframework.data.repository.CrudRepository;

import sia.taco_cloud.Model.tacos.Ingredient;


 
public interface IngredientRepository extends CrudRepository<Ingredient,String> {

  
}