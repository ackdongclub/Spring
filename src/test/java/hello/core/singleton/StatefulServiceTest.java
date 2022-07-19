package hello.core.singleton;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        /*
        //ThreadA: A사용자가 10000원을 주문
        statefulService1.order("userA", 10000);
        //ThreadA: B사용자가 20000원을 주문
        statefulService2.order("userB", 20000);*/

        //ThreadA: A사용자가 10000원을 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadA: B사용자가 20000원을 주문
        int userBPrice = statefulService2.order("userB", 20000);



        //ThreadA: 사용자A 주문 금액 조회
        //int price = userAPrice.getPrice();
        System.out.println("price = " + userAPrice);

        //Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig {
        @Bean //spring bean은 항상 무상태(stateless)로 설계해야 한다.
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}