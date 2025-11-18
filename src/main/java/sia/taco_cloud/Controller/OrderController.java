package sia.taco_cloud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import sia.taco_cloud.Model.tacos.Order;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {
 
  @GetMapping("/current")
  public String orderForm() {
    return "orderForm.xhtml";
  }

  @PostMapping
public String processOrder( @Valid Order order, Errors error ,SessionStatus sessionStatus) {
    if (error.hasErrors()) {
      //log.info("Error Processing order: {} error: {}", order,error);
      return "orderForm.xhtml";
    }
  log.info("Order submitted: {}", order);
  sessionStatus.setComplete();
 
  return "redirect:/";
}
 
}