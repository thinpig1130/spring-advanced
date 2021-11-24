package hello.advanced.app.v5;

import hello.advanced.trace.callback.TraceTemplate;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRespositoryV5 orderRespository;
    private final TraceTemplate<Void> traceTemplate;

    @Autowired
    public OrderServiceV5(OrderRespositoryV5 orderRespository, LogTrace trace) {
        this.orderRespository = orderRespository;
        this.traceTemplate = new TraceTemplate(trace);
    }

    public void orderItem(String itemId){
        traceTemplate.execute("OrderService.orderItem()", () -> {
            orderRespository.save(itemId);
            return null;
        });
    }
}
