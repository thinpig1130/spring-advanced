package hello.advanced.app.v4;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
public class OrderRespositoryV4 {

    private final LogTrace trace;

    public void save(String itemId){

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if(itemId.equals("ex")){
                    throw new IllegalMonitorStateException("μμΈλ°μ");
                }
                sleep(1000);
                return null;
            }
        };

        template.execute("OrderRespository.save()");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
