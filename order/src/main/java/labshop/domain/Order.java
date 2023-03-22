package labshop.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import labshop.OrderApplication;
import labshop.domain.OrderPlaced;
import lombok.Data;

@Entity
@Table(name = "Order_table2")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productId;

    private Integer qty;

    private String customerId;

    private Double amount;

    @PostPersist
    public void onPostPersist() {
        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        labshop.external.UpdateStockCommand updateStockCommand = new labshop.external.UpdateStockCommand();
        // mappings goes here
        OrderApplication.applicationContext
            .getBean(labshop.external.InventoryService.class)
            .updateStock(/* get???(), */updateStockCommand);

        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
    }

    @PrePersist
    public void onPrePersist() {
        // Get request from Order
        //labshop.external.Order order =
        //    Application.applicationContext.getBean(labshop.external.OrderService.class)
        //    .getOrder(/** mapping value needed */);

    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
