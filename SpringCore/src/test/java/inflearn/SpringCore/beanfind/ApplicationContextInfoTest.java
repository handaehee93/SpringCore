package inflearn.SpringCore.beanfind;

import inflearn.SpringCore.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);



    @Test
    @DisplayName("모든 빈 조회")
    void findAllBean () {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println("등록된 빈 들의 이름을 배열로 받음 == " + beanDefinitionNames);
        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println("등록된 빈 이름 조회 ==" + beanDefinitionName);

            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("빈 이름으로 조회한 값 == " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 조회")
    void findApplicationBean () {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            System.out.println("각 빈에 관한 정보들 == " + beanDefinition);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("빈 이름 = " + beanDefinitionName + ", 빈 값 =" + bean);
            }
        }


    }
}
