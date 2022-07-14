package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationBeanContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //list가 있을 경우 iter하고 tab하면 for문 자동 완성
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBeanDefinitionNames();
            System.out.println("name = " + beanDefinitionName + "object = " + bean);
        }

    } @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        //list가 있을 경우 iter하고 tab하면 for문 자동 완성
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //bean 하나에 대한 정보를 꺼낼 수 있다

            //Role ROLE_APPLICATION : 직접 등록한 애플리케이션 빈 or 외부 API 사용시 쓰는 빈
            //Role ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
           if (beanDefinition.getRole() == BeanDefinition.ROLE_INFRASTRUCTURE) {
                Object bean = ac.getBeanDefinition(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "object = " + bean);
            }
        }

    }
}
