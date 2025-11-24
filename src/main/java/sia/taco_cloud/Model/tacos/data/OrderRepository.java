package sia.taco_cloud.Model.tacos.data;

import org.springframework.data.repository.CrudRepository;

import sia.taco_cloud.Model.tacos.TacoOrder;

public interface OrderRepository extends CrudRepository<TacoOrder,Long> {
    


}
