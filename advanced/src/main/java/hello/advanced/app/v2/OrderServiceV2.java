package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRespositoryV2 orderRespository;
    private final HelloTraceV2 trace;


    public void orderItem(TraceId prevTraceId, String itemId){

        TraceStatus status = null;
        try {
            status = trace.beginSync(prevTraceId, "OrderService.orderItem()");
            orderRespository.save(status.getTraceId(), itemId);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져 주어야 한다.
        }
    }
}
