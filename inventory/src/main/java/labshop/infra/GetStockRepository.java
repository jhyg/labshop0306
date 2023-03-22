package labshop.infra;

import java.util.List;
import labshop.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "getStocks", path = "getStocks")
public interface GetStockRepository
    extends PagingAndSortingRepository<GetStock, Long> {}
