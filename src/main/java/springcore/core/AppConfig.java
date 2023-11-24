package springcore.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springcore.core.discount.DiscountPolicy;
import springcore.core.discount.FixDiscountPolicy;
import springcore.core.discount.RateDiscountPolicy;
import springcore.core.member.MemberService;
import springcore.core.member.MemberServiceImpl;
import springcore.core.member.MemoryMemberRepository;
import springcore.core.order.OrderService;
import springcore.core.order.OrderServiceImpl;
// 먼저 Configuration 어노테이션을 붙여 준다.
@Configuration
public class AppConfig {


    // Bean 어노테이션을 붙여 주면 이것 들이 스프링 컨테이너에 등록이 된다. dd
    // MemberService 역할
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }
    // MemoryMemberRepository 역할
    @Bean
    public  MemoryMemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }
    // OrderService 역할
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(MemberRepository(), new FixDiscountPolicy());
    }
    // DiscountPolicy 역할
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
