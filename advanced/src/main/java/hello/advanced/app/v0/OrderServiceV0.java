package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV0 {

    private final OrderRespositoryV0 orderRespository;

    public void orderItem(String itemId){
        orderRespository.save(itemId);
    }
}
