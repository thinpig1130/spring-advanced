package hello.advanced.trace.threadlocal;

import hello.advanced.trace.threadlocal.code.FieldService;
import hello.advanced.trace.threadlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class ThreadLocalServiceTest {

    private ThreadLocalService service = new ThreadLocalService();

    @Test
    @DisplayName("동시성 문제 발생 예제")
    void field() {
        log.info("main start");
        Runnable userA = () ->{
            service.logic("userA");
        };

        Runnable userB = () -> {
            service.logic("userB");
        };

        Runnable userC = () -> {
            service.logic("userC");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadA.setName("thread-B");
        sleep(10);
        Thread threadC = new Thread(userC);
        threadA.setName("thread-C");

        threadA.start();
        sleep(2000); // 동시성 문제 발생하지 않음
        threadB.start();
        threadC.start(); // 동시성 문제 발생.

        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
