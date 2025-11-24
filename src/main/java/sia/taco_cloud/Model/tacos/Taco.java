package sia.taco_cloud.Model.tacos;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Table
public class Taco {
    
    @NotNull
    @Size(min=5, message = "The name field must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min=1, message = "Your taco must have at least 1 ingredient")
    private List<Ingredient> ingredients;

    @Id
    private long id;

    private Date createdAt = new Date();
}
