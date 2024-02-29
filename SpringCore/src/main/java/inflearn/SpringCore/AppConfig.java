package inflearn.SpringCore;

import inflearn.SpringCore.discount.DiscountPolicy;
import inflearn.SpringCore.discount.FixDiscountPolicy;
import inflearn.SpringCore.discount.RateDiscountPolicy;
import inflearn.SpringCore.member.MemberRepository;
import inflearn.SpringCore.member.MemberService;
import inflearn.SpringCore.member.MemberServiceImpl;
import inflearn.SpringCore.member.MemoryMemberRepository;
import inflearn.SpringCore.order.OrderService;
import inflearn.SpringCore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // 메소드 명이 역할, 반환 값이 구현
    @Bean
    public MemberService memberService () {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository () {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService () {
        return new OrderServiceImpl(memberRepository (), discountPolicy ());
    }
    @Bean
    public DiscountPolicy discountPolicy () {
        return new FixDiscountPolicy();
    }

}
