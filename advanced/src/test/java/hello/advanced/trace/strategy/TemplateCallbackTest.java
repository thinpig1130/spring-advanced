package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV2;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import hello.advanced.trace.strategy.code.template.TimeLogTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Time;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    @DisplayName("탬플릿 콜백 패턴 적용(= 실행시점에 로직을 주입하는 전략패턴 이름)")
    void callbackV1() {
        TimeLogTemplate template = new TimeLogTemplate();

        template.execute(()->log.info("콜백 실행합니다.1"));
        template.execute(()->log.info("콜백 실행합니다.2"));
    }

}
