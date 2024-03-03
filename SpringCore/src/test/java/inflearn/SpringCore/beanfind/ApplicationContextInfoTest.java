package inflearn.SpringCore.beanfind;

import inflearn.SpringCore.AppConfig;
import inflearn.SpringCore.member.MemberRepository;
import inflearn.SpringCore.member.MemberService;
import inflearn.SpringCore.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    // 빈 전체 조회 하기
    @Test
    @DisplayName("모든 빈 조회")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        System.out.println("등록된 빈 들의 이름을 배열로 받음 == " + beanDefinitionNames);
        for (String beanDefinitionName : beanDefinitionNames) {
            // 스프링 컨테이너에 등록된 Key
            System.out.println("등록된 빈 이름 조회 ==" + beanDefinitionName);

            Object bean = ac.getBean(beanDefinitionName);
            // 스프링 컨테이너에 등록된 Value
            System.out.println("빈 이름으로 조회한 값 == " + bean);
        }
    }

    // 빈 전체 조회 하기 ( 애플리케이션과 직접적으로 관려된 빈 만 조회 )
    @Test
    @DisplayName("애플리케이션 빈 조회")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            // getBeanDefinition을 활용하면 빈 하나하나에 대한 메타 데이터 정보를 조회 할 수 있다.
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            System.out.println("각 빈에 관한 메타 정보들 == " + beanDefinition);

            // 개발자가 직접 빈으로 등록한 것들만 조회
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("빈 이름 = " + beanDefinitionName + ", 빈 값 =" + bean);
            }
        }
    }


    // 개별적으로 빈 조회 ( 전체 조회 x )
    @Test
    @DisplayName("빈 이름으로 조회 ")
    void findBeanByName() {
        // getBean의 경우 빈의 이름과 반환 타입을 전할할 수 있는데 반환 타입은 인터페이스로 해도 되고, 구현체의
        // 타입으로 해도 된다. 반환 타입을 MemberServiceImpl.class로 해도 되는 것.
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
        // memberService라는 이름으로 등록된 빈의 vlaue는 new로 생성한 MemberServiceImpl의 인스턴스
        // 이므로 그것이 맞는지 확인하는 것.
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    // 아래의 타입은 인터페이스
    @Test
    @DisplayName("이름 없이 타입 으로 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        // 빈으로 등록된 반환 타입이 MemberService인 메서드의 반환 값이 MemberServiceImpl이므로
        // 타입으로 조회한 빈의 vlaue가 MemberServiceImpl의 인스턴인지 확인하는 것.
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        System.out.println(memberService);
    }

    // 아래의 타입은 구현체
    // 하지만 객체 지향의 원칙에서 항상 추상화 에만 의존해야 하므로 이렇게 구현체로 조회 하는 것은
    // 구현에 의존하는 것이기 때문에 좋지 않다.
    @Test
    @DisplayName("이름 없이 구체 타입 으로 조회")
    void findBeanByDetailType() {
        MemberService memberService = ac.getBean(MemberServiceImpl.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
        System.out.println(memberService);
    }


    // 컨테이너에 동일한 타입의 스피링 빈이 존재하는 경우 빈 조회
    // 현재 AppConfig에 MemoryMemberRepository를 반환하는 빈이 2개다.
    @Test
    @DisplayName("같은 타입의 스프링 빈이 존재하는 경우 빈 조회")
    void findDuplicateTypeBean() {
        MemberRepository bean = ac.getBean("memberRepository2", MemberRepository.class);
        Assertions.assertThat(bean).isInstanceOf(MemberRepository.class);
    }

    // 특정 타입의 빈을 모두 조회하기
    @Test
    @DisplayName("특정 타입의 빈 모두 조회하기")
    void findAllBeanByType () {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("같은 타입인 빈들의 key 값 = " + key);

        }

    }
}
