package labshop.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import labshop.config.kafka.KafkaProcessor;
import labshop.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class GetStockViewHandler {

    @Autowired
    private GetStockRepository getStockRepository;
}
