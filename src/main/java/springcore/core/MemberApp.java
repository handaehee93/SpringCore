package springcore.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springcore.core.member.Grade;
import springcore.core.member.Member;
import springcore.core.member.MemberService;
import springcore.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        // 순수 자바로 되어 있던 것들을 일단 주석처리 한다.
        // MemberService memberService = new MemberServiceImpl(memberRepository);
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        // ApplicationContext라는 것이 스프링 컨네이너 라고 보면 되고, 모든게 여기서 부터 시작 된다.
        // 아래와 같이 AppConfig클래스를 전달 하면 AppConfig에서 Bean으로 설정한 것들을 관리해 준다.
        ApplicationContext applicationcontext = new AnnotationConfigApplicationContext(AppConfig.class);

        // 그럼 이제 기존에 AppConfig에서 직접 꺼내오던 메서들을 스프링 컨테이너에서 꺼내 오도록 해야 한다.
        // MemberService를 꺼내와 보자.
        // Bean으로 등록이 될 때 해당 메서드의 이름으로 등록이 된다. 따라서 getBean에 가져올 메서드 이름을 입력하고,
        // 두번째로 반환 타입을 입력한다.

        MemberService memberService = applicationcontext.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("find member = " + findMember.getName());
        System.out.println("new member = " + member.getName());
    }
}
