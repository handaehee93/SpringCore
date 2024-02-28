package inflearn.SpringCore;

import inflearn.SpringCore.discount.RateDiscountPolicy;
import inflearn.SpringCore.member.MemberService;
import inflearn.SpringCore.member.MemberServiceImpl;
import inflearn.SpringCore.member.MemoryMemberRepository;
import inflearn.SpringCore.order.OrderService;
import inflearn.SpringCore.order.OrderServiceImpl;

public class AppConfig {
    // 각각의 인터페이스를 반환 타입으로 하는 메서드를 만들고 반환 값으로 구현체에 인스턴스를 전달한다.
    // 이렇게 하면 구현체에서는 인터페이스에만 의존하게 되고, AppConfig에서 전달 받은 인스턴스를 통해
    // 인터페이스의 구현체를 사용하게 된다.
    public MemberService memberService () {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService () {
        return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
