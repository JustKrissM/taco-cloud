package sia.taco_cloud.Controller;


import java.util.List;
import java.util.stream.Collectors;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import org.springframework.validation.Errors;
import lombok.extern.slf4j.Slf4j;
import sia.taco_cloud.Model.tacos.Ingredient;
import sia.taco_cloud.Model.tacos.Ingredient.Type;
import sia.taco_cloud.Model.tacos.TacoOrder;
import sia.taco_cloud.Model.tacos.Taco;
import sia.taco_cloud.Model.tacos.data.IngredientRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;






@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
    

    private final IngredientRepository ingredientRepo;
 

    public DesignTacoController(IngredientRepository ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
    }
    
    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        Iterable<Ingredient> ingredients = ingredientRepo.findAll();
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
        model.addAttribute(type.toString().toLowerCase(),filterByType((List<Ingredient>) ingredients, type));
        }
    }

    
 

    @GetMapping
    public String showDesignForm() {
        return "design.xhtml";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder  order){
        
        if (errors.hasErrors()) {
            //log.info("Error Processing taco: {}", taco);
             return "design.xhtml";
        }
        order.addTaco(taco);
        log.info("Processing taco: {}", taco);
        return "redirect:/orders/current";
    }
   
    
    @ModelAttribute(name = "order")
    public TacoOrder order(){
        return new TacoOrder(); 
    } 

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco(); 
    } 
    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
    return ingredients
              .stream()
              .filter(x -> x.getType().equals(type))
              .collect(Collectors.toList());
  }
 
    
}
