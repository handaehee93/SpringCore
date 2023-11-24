package springcore.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton () {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);

        // A사용자가 10000원 주문
        int userAPrice = statefulService.order("userA",10000);
        // B사용자가 20000원 주문
        int userBPrice = statefulService1.order("userB", 20000);
        // A사용자가 본인의 주문금액 조회 (10000원이 나와야 함)

        System.out.println(userAPrice);
    }

    static class TestConfig {
        @Bean
        public  StatefulService statefulService() {
            return new StatefulService();
        }
    }
}