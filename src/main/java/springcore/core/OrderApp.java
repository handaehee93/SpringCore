package springcore.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springcore.core.member.Grade;
import springcore.core.member.Member;
import springcore.core.member.MemberService;
import springcore.core.member.MemberServiceImpl;
import springcore.core.order.Order;
import springcore.core.order.OrderService;
import springcore.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        // 멤버랑, 오더 서비스를 만든다.
        // MemberService memberService = new MemberServiceImpl(memberRepository);
        // OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
        // AppConfig appConfig = new AppConfig();
        // MemberService memberService = appConfig.memberService();
        // OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);


        long memberId = 1L;
        // 회원을 저장 하고
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        // 오더를 생성한다.
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
    }

