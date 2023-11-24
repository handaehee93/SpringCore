package springcore.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springcore.core.AppConfig;
import springcore.core.member.MemberService;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer () {
        AppConfig appConfig = new AppConfig();

        //서로 다른 사용자가 똑같은 요청을 하면 객체가 2번 반환 되는지 확인 하는 코드
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // 출력해 보면 참조값이 다른 것을 확인할 수 있다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        AppConfig appConfig = new AppConfig();
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //서로 다른 사용자가 똑같은 요청을 하면 객체가 2번 반환 되는지 확인 하는 코드
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        // 출력해 보면 참조값이 다른 것을 확인할 수 있다.
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

}
