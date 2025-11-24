package sia.taco_cloud.Model.tacos.data;

import sia.taco_cloud.Model.tacos.TacoOrder;

public interface OrderRepository {
    
    TacoOrder save(TacoOrder order);
    
}
