package springcore.core.beanfinder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springcore.core.AppConfig;

import java.text.Annotation;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean () {
       String[] beanDefinitionNames =  ac.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name =" + beanDefinitionName + " object = " + bean );

        }
    };


    // 아래는 스프링에서 필요해서 자체적으로 가지고 있는 Bean말고, 순수 어플리케이션을 개발할 때 등록한 bean을
    // 출력하는 코드
@Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean () {
       String[] beanDefinitionNames =  ac.getBeanDefinitionNames();
        for (String beanDefinitionName: beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name =" + beanDefinitionName + " object = " + bean );
            }
        }
    }
}
