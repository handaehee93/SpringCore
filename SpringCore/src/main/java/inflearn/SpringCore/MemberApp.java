package inflearn.SpringCore;

import inflearn.SpringCore.member.Grade;
import inflearn.SpringCore.member.Member;
import inflearn.SpringCore.member.MemberService;
import inflearn.SpringCore.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("가입한 회원" + member.getName());
        System.out.println("찾은 회원" + findMember.getName());
    }
}
