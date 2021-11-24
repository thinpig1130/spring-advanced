package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    @DisplayName("전략 패턴")
    void strategyV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }


    @Test
    @DisplayName("전략패턴 적용")
    void strategyV1() {
        // 조립
        Strategy strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        // 실행
        context1.execute();

        // 조립
        Strategy strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        
        // 실행
        context2.execute();
    }


    @Test
    @DisplayName("전략패턴 적용 (익명 내부 클래스)")
    void strategyV2() {
        // 조립 (람다 이용)
        ContextV1 context1 = new ContextV1(() -> log.info("비지니식 익명 로직 1 실행"));
        // 실행
        context1.execute();

        // 조립 (익명 함수 생성 후 주입)
        ContextV1 context2 = new ContextV1( new Strategy() {
            @Override
            public void call() {
                log.info("비지니식 익명 로직 2 실행");
            }
        });

        // 실행
        context2.execute();
    }

}
