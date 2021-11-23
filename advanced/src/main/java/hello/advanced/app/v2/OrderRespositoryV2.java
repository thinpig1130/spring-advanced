package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRespositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId prevTraceId, String itemId){

        TraceStatus status = null;
        try {
            status = trace.beginSync(prevTraceId, "OrderRespository.save()");
            if(itemId.equals("ex")){
                throw new IllegalMonitorStateException("예외발생");
            }
            sleep(1000);
            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져 주어야 한다.
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
