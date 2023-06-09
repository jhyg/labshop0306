package labshop.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
    name = "inventory",
    url = "${api.url.inventory}",
    fallback = InventoryServiceImpl.class
)
public interface InventoryService {
    @RequestMapping(
        method = RequestMethod.PUT,
        path = "/inventories/{id}/updatestock"
    )
    public void updateStock(
        @PathVariable("id") Long id,
        @RequestBody UpdateStockCommand updateStockCommand
    );
}
