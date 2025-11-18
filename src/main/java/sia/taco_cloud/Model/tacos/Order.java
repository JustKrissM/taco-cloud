package sia.taco_cloud.Model.tacos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Order {
  
  @NotBlank(message = "Please enter a delivery name")
  private String deliveryName;
  
  @NotBlank(message = "Please enter your street address")
  private String deliveryStreet;
  
  @NotBlank(message = "Please enter your city address")
  private String deliveryCity;
  
  @NotBlank(message = "Please enter your state address")
  private String deliveryState;
  
  @NotBlank(message = "Please enter your zip code")
  private String deliveryZip;
  
  @CreditCardNumber(message="Please enter a  valid credit card number")
  private String ccNumber;

  @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",message="Must be formatted MM/YY")
  private String ccExpiration;

  @Digits(integer=3, fraction=0, message="Please enter a valid CVV")
  private String ccCVV;
 
  private List<Taco> tacos = new ArrayList<>();
 
  public void addTaco(Taco taco) {
    tacos.add(taco);
  }
}