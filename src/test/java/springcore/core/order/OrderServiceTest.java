package springcore.core.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import springcore.core.AppConfig;
import springcore.core.member.Grade;
import springcore.core.member.Member;
import springcore.core.member.MemberService;
import springcore.core.member.MemberServiceImpl;

public class OrderServiceTest {
    // MemberService memberService = new MemberServiceImpl(memberRepository);
    // OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

    MemberService memberService;
    OrderService orderService;
    // @BeforeEach는 각각의 테스트 메서드 실행 전에 실행되게 하는 역할을 한다.
    @BeforeEach
    public void beforeEach () {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }
    @Test
    void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
