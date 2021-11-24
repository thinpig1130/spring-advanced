package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    @DisplayName("전략패턴 V2 적용 : 실행시점에 주입")
    void strategyV2() {

        ContextV2 context = new ContextV2();

        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());

        context.execute(()->log.info("익명전략 실행 1 "));
        context.execute(()->log.info("익명전략 실행 2 "));
    }

}
